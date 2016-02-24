/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globomart.retail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 *
 * @author cyberaka
 */
@MessageEndpoint
public class MessageProductReceiver {
    
    @ServiceActivator (inputChannel = Sink.INPUT)
    public void acceptProduct(String pn) {
        System.out.println("======\n" + pn + "\n============");
        this.productRepository.save(new Product(pn, pn, pn, 1));
    }
    
    @Autowired
    private ProductRepository productRepository;
}