package com.globomart.retail;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

@EnableBinding(Sink.class)
@EnableDiscoveryClient
@SpringBootApplication
public class GlobomartProductCatalogServiceApplication {

    @Bean
    AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
    
    @Bean
    CommandLineRunner runner(ProductRepository rr) {
        return args -> {
          Arrays.asList("iPhone, iPad, Android".split(","))
                  .forEach( x -> rr.save(new Product(x, x, x, 1)));
          rr.findAll().forEach(System.out::println);
        };
    }
    
    public static void main(String[] args) {
        SpringApplication.run(GlobomartProductCatalogServiceApplication.class, args);
    }
    
}
