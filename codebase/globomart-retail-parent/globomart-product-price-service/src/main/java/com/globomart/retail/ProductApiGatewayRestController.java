/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globomart.retail;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Collection;
import java.util.Collections;
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

    @RequestMapping(method = RequestMethod.POST)
    public void write(@RequestBody Product r) {
        this.messageChannel.send(MessageBuilder.withPayload(r.getProductName()).build());
    }

    public Collection<String> getProductNamesFallback() {
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "getProductNamesFallback")
    @RequestMapping("/names")
    public Collection<String> getProductNames() {
        ParameterizedTypeReference<Resources<Product>> ptr
                = new ParameterizedTypeReference<Resources<Product>>() {
        };
        ResponseEntity<Resources<Product>> responseEntity
                = this.restTemplate.exchange("http://globomart-product-catalog-service/products", HttpMethod.GET, null, ptr);

        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(Product::getProductName)
                .collect(Collectors.toList());
    }
}
