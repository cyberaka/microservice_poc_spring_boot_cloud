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
public interface PriceRepository extends JpaRepository<Price, Long> {       
    
    @RestResource (path = "by-product")
    Collection<Price> findPriceByProductId(@Param("productId") Long productId);
    
}
