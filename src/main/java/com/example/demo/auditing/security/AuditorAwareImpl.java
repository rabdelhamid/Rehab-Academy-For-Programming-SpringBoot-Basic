/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.auditing.security;

import com.example.demo.security.entities.CustomUser;
import com.example.demo.security.entities.Users;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author user
 */
//https://attacomsian.com/blog/spring-data-jpa-auditing#
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
         //return Optional.of(System.getProperty("user.name"));
           Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated()) {
              return null;
            }
            return Optional.of(((CustomUser) authentication.getPrincipal()).getUsername());
    }
   
}