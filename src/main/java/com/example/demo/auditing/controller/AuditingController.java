/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.auditing.controller;

import com.example.demo.auditing.business.service.AuditService;
import com.example.demo.security.controllers.secure.*;
import com.example.demo.Business.services.DemoService;
import com.example.demo.controllers.*;
import com.example.demo.model.entities.dtos.ProductDto;
import com.example.demo.security.daos.UsersRepository;
import com.example.demo.security.entities.Users;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class AuditingController {
   @Autowired
    AuditService auditService;
   @Autowired
    UsersRepository usersRepository;
   
    @RequestMapping(method = RequestMethod.POST,value = "/createUser")    
    public ResponseEntity createProduct(@RequestBody Users user) {
       user= auditService.createUser(user);
       
        return new ResponseEntity<>(usersRepository.findById(user.getId()), HttpStatus.CREATED);
    }
    
}
