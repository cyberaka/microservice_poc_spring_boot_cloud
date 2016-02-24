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

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

/**
 * Entry point into the catalog service. This application is configured to 
 * register with eureka server, accept incoming messages to add new products
 * as well as serve any product query required by other services. 
 * 
 * @author cyberaka
 */
@EnableBinding(Sink.class)
@EnableDiscoveryClient
@SpringBootApplication
public class GlobomartProductCatalogServiceApplication {

    /**
     * Necessary for zipkin based monitoring. 
     * 
     * @return 
     */
    @Bean
    AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    /**
     * Pre-populating the in memory database with some information. 
     * @param rr
     * @return 
     */
    @Bean
    CommandLineRunner runner(ProductRepository rr) {
        return args -> {
            Arrays.asList("iPhone, iPad, Android".split(","))
                    .forEach(x -> rr.save(new Product(x, x + " Description", x + " Type", (int) (Math.random()*100))));
            rr.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GlobomartProductCatalogServiceApplication.class, args);
    }

}
