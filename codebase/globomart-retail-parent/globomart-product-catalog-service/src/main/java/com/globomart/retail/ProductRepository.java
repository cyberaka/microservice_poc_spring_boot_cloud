/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globomart.retail;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author cyberaka
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @RestResource (path = "by-id")
    Collection<Product> findById(@Param("pi") Long pi);
    
    @RestResource (path = "by-name")
    Collection<Product> findByProductName(@Param("pn") String pn);
    
    @RestResource (path = "by-type")
    Collection<Product> findByProductType(@Param("pt") String pt);
    
}
