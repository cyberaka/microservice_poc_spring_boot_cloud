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

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Product repository for product entity. Serves as both JPA repository and a REST
 * controller.
 * 
 * @author cyberaka
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Lookup by name. This will be available under /search/ path. For example:
     * http://<host>:<port>/products/search/by-name?productName=iPad
     * 
     * @param productName
     * @return 
     */
    @RestResource (path = "by-name")
    Collection<Product> findByProductName(@Param("productName") String productName);
    
    /**
     * Lookup by name. This will be available under /search/ path. For example:
     * http://<host>:<port>/products/search/by-type?productName=iPad
     * 
     * @param productType
     * @return 
     */
    @RestResource (path = "by-type")
    Collection<Product> findByProductType(@Param("productType") String productType);
    
}
