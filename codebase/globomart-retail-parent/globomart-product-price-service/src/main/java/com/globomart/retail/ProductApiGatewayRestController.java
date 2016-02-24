/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.globomart.retail;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * An API gateway implementation for outside world to talk to both the price
 * as well as the catalog service api.
 * 
 * @author cyberaka
 */
@RestController
@RequestMapping("/products")
public class ProductApiGatewayRestController {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Output(Source.OUTPUT)
    @Autowired
    private MessageChannel messageChannel;
    
    @Autowired
    private PriceRepository priceRepository;

    /**
     * A POST request to the API gateway of price service will allow a new 
     * product to be created.
     * 
     * @param r 
     */
    @RequestMapping(method = RequestMethod.POST)
    public void write(@RequestBody SimpleProduct r) {
        this.messageChannel.send(MessageBuilder.withPayload(r).build());
    }

    /**
     * In case the actual method fails, hystrix will call this method instead.
     * 
     * @param productId
     * @return 
     */
    public Collection<String> getProductNamesFallback(Long productId) {
        return Collections.emptyList();
    }
    
    /**
     * In case the actual method fails, hystrix will call this method instead.
     * 
     * @return 
     */
    public List<SimplePrice> getPriceByProductIdFallback(Long productId) {
        return Collections.emptyList();
    }

    /**
     * A debug API to list all the product names. This demonstrates that the 
     * price service and catalog service are connected.
     * 
     * @return 
     */
    @HystrixCommand(fallbackMethod = "getProductNamesFallback")
    @RequestMapping("/names")
    public Collection<String> getProductNames() {
        ParameterizedTypeReference<Resources<SimpleProduct>> ptr
                = new ParameterizedTypeReference<Resources<SimpleProduct>>() {
        };
        ResponseEntity<Resources<SimpleProduct>> responseEntity
                = this.restTemplate.exchange("http://globomart-product-catalog-service/products", HttpMethod.GET, null, ptr);

        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(SimpleProduct::getProductName)
                .collect(Collectors.toList());
    }
    
    /**
     * Implements a lookup using a product id. The product id is used to load
     * a product and find out all the prices of that product in our database.
     * 
     * @param productId
     * @return 
     */
    @HystrixCommand(fallbackMethod = "getPriceByProductIdFallback")
    @RequestMapping("/find_price_by_product_id")
    List<SimplePrice> findPriceByProductId(Long productId) {
        if (productId == null) { // Failsafe check.
            return null;
        }
        // We are not expecting a collection so no point of using Resource/Stream
        ParameterizedTypeReference<SimpleProduct> ptr
                = new ParameterizedTypeReference<SimpleProduct>() {
        };
        // Make a call using ribbon service and zuul proxy service to the catalog service.
        ResponseEntity<SimpleProduct> responseEntity
                = this.restTemplate.exchange(
                        "http://globomart-product-catalog-service/products/" + productId, 
                        HttpMethod.GET, 
                        null, 
                        ptr);

        SimpleProduct product = responseEntity.getBody();
        if (product != null) { // If a product was found then lets load a price. 
            Collection<Price> priceColl = priceRepository.findPriceByProductId(productId);
            ArrayList<SimplePrice> priceList = new ArrayList<>();
            priceColl.forEach(prc -> priceList.add(new SimplePrice(prc.getId(), product, prc.getPrice(), new Date(System.currentTimeMillis()))));
            return priceList;
        } else {
            return null;
        }
    }
}
