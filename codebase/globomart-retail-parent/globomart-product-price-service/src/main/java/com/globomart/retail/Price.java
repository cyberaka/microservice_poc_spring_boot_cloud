/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globomart.retail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author cyberaka
 */
@Entity
public class Price {
    
    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    
    private Double price;

    public Price(Long productId, Double price) {
        this.productId = productId;
        this.price = price;
    }

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", productId=" + productId + ", price=" + price + '}';
    }

}
