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

/**
 * A POJO class to denote a Product entity as a JSON object. Conversion is handled
 * automatically by Spring-REST using Jackson.
 * 
 * @author cyberaka
 */
public class SimpleProduct {

    private Long id;

    private String productName;

    private String productDescription;

    private String productType;

    private int stockInHand;

    public SimpleProduct(Long id, String productName, String productDescription,
            String productType, int stockInHand) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productType = productType;
        this.stockInHand = stockInHand;
    }

    public SimpleProduct() {
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
        return "SimpleProduct{" + "id=" + id + ", productName=" + productName + ", productDescription=" + productDescription + ", productType=" + productType + ", stockInHand=" + stockInHand + '}';
    }

}
