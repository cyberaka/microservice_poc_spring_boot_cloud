/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globomart.retail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cyberaka
 */
@RefreshScope
@RestController
public class MessageRestController {
    
    @Value("${message}")
    private String message;
    
    @RequestMapping("/message")
    String message() {
        return this.message;
    }
}