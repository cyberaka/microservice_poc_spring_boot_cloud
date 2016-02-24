/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globomart.retail;

/**
 *
 * @author cyberaka
 */
public class SimplePrice {
    
    private Long id;

    private SimpleProduct product;
    
    private Double price;

    public SimplePrice() {
    }

    public SimplePrice(Long id, SimpleProduct product, Double price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleProduct getProduct() {
        return product;
    }

    public void setProduct(SimpleProduct product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SimplePrice{" + "id=" + id + ", product=" + product + ", price=" + price + '}';
    }
    
}
