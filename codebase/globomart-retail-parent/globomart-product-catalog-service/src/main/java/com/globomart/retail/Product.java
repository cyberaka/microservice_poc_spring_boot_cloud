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
class Product {

    @Id
    @GeneratedValue
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

