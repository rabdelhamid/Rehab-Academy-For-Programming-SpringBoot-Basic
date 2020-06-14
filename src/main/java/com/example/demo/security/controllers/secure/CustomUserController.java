/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.controllers.secure;

import com.example.demo.security.entities.CustomUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class CustomUserController {
    
    @RequestMapping(method = RequestMethod.GET,value = "/getCustomUserData")    
    public ResponseEntity getCustomUserData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser =(CustomUser) auth.getPrincipal();
        
        String fullName="";
        if(customUser.getFirstName()!=null&&customUser.getLastName()!=null)
            fullName=customUser.getFirstName()+" "+customUser.getLastName();
        
        return new ResponseEntity<String>(fullName, HttpStatus.OK);
    }
  
    
}
