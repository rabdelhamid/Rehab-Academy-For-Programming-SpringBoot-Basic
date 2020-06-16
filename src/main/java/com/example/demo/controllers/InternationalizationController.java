/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.LocalizedBusinessException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
//https://stackoverflow.com/questions/55414840/thymeleaf-not-redirecting-to-index-html
@Controller
public class InternationalizationController {
  
     @RequestMapping("/")
     public String hello() {
       return "home";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getLocalExceptionMessage")    
    public ResponseEntity getDefaultLocalMessage(HttpServletRequest request) {
        LocaleContextHolder.setLocale(request.getLocale());
       throw new LocalizedBusinessException("BAD_REQUEST");

    }
    
    
    
}
