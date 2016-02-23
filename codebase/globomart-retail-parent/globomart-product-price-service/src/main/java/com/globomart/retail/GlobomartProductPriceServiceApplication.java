package com.globomart.retail;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
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

@EnableZuulProxy
@EnableBinding(Source.class)
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class GlobomartProductPriceServiceApplication {

    @Bean
    AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(GlobomartProductPriceServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/products")
class ProductApiGatewayRestController {

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

class Product {

    private Long id;

    private String productName;

    private String productDescription;

    private String productType;

    private int stockInHand;

    public Product(String productName, String productDescription,
            String productType, int stockInHand) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productType = productType;
        this.stockInHand = stockInHand;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getStockInHand() {
        return stockInHand;
    }

    public void setStockInHand(int stockInHand) {
        this.stockInHand = stockInHand;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName=" + productName + ", productDescription=" + productDescription + ", productType=" + productType + ", stockInHand=" + stockInHand + '}';
    }

}
