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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * A messaging endpoint to enable other services to create new product 
 * entries inside the product repository. 
 * 
 * @author cyberaka
 */
@MessageEndpoint
public class MessageProductReceiver {
    
    @ServiceActivator (inputChannel = Sink.INPUT)
    public void acceptProduct(String pn) {
        this.productRepository.save(new Product(pn, pn, pn, 1));
    }
    
    @Autowired
    private ProductRepository productRepository;
}