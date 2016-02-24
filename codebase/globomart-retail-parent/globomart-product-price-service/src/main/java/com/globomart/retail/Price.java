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

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Price entity class.
 * 
 * @author cyberaka
 */
@Entity
public class Price implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    
    private Double price;
    
    private Date priceTimestamp;

    public Price(Long productId, Double price, Date priceTimestamp) {
        this.productId = productId;
        this.price = price;
        this.priceTimestamp = priceTimestamp;
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

    public Date getPriceTimestamp() {
        return priceTimestamp;
    }

    public void setPriceTimestamp(Date priceTimestamp) {
        this.priceTimestamp = priceTimestamp;
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", productId=" + productId + ", price=" + price + ", priceTimestamp=" + priceTimestamp + '}';
    }

}
