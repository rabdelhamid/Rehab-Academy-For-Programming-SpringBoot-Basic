/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Business.services;

import com.example.demo.model.entities.dtos.ProductDto;
import javax.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


/**
 *
 * @author user
 */
@Service
@Transactional
public class DemoService {
    
     //third place to put PreAuthorize annotation
     @PreAuthorize("hasRole('ADMIN')")
     public ProductDto retrieveAuthorizedProducts() {         
        return new ProductDto("1", "iPhone", 999.99f);
     }
    
     public void removeProducts(String id) {         
        //to do
     }
}
