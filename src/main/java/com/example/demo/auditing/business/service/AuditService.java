/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.auditing.business.service;

import com.example.demo.Business.services.*;
import com.example.demo.model.entities.dtos.ProductDto;
import com.example.demo.security.daos.UsersRepository;
import com.example.demo.security.entities.Users;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


/**
 *
 * @author user
 */
@Service
@Transactional
public class AuditService {
    @Autowired 
     private UsersRepository usersRepository;
     public Users createUser(Users user)
     {
         usersRepository.save(user);
       
         return user;
     }
}
