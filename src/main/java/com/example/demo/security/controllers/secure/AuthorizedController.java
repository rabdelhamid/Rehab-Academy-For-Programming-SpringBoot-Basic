/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.controllers.secure;

import com.example.demo.Business.services.DemoService;
import com.example.demo.controllers.*;
import com.example.demo.model.entities.dtos.ProductDto;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
//first place to put PreAuthorize annotation
public class AuthorizedController {
    @Autowired
    DemoService demoService;
    
    // second place to put PreAuthorize annotation
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET,value = "/getAllEmployeeData")    
    public ResponseEntity getAllEmployeeData() {
        
         return new ResponseEntity<String>("Single Role Test", HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @RequestMapping(method = RequestMethod.GET,value = "/getEmployeeData")    
    public ResponseEntity getEmployeeData() {
         return new ResponseEntity<String>("Multiple Role Test", HttpStatus.OK);
    } 
   
    @RequestMapping(method = RequestMethod.GET,value = "/retrieveAuthorizedProducts")    
    public ResponseEntity getServiceData() {
        ProductDto productDto=demoService.retrieveAuthorizedProducts();
         return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }
    
}
