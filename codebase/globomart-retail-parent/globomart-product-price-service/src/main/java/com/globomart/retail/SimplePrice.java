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

import java.sql.Date;

/**
 * A POJO class to denote a Price entity as a JSON object. Conversion is handled
 * automatically by Spring-REST using Jackson.
 * 
 * @author cyberaka
 */
public class SimplePrice {
    
    private Long id;

    private SimpleProduct product;
    
    private Double price;
    
    private Date priceDate;

    public SimplePrice() {
    }

    public SimplePrice(Long id, SimpleProduct product, Double price, Date priceDate) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.priceDate = priceDate;
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

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    @Override
    public String toString() {
        return "SimplePrice{" + "id=" + id + ", product=" + product + ", price=" + price + ", priceDate=" + priceDate + '}';
    }

}
