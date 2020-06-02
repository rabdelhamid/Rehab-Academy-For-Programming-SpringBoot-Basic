/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.services;


import com.example.demo.security.daos.UsersRepository;
import com.example.demo.security.entities.CustomUser;
import com.example.demo.security.entities.Role;
import com.example.demo.security.entities.Users;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
/**
 *
 * @author rehab.abd-elhamid
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UsersRepository userRepository;
    
   /*Without custom user properties & without actual roles*/
//    @Override
//    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
//        
//      
//                Users  user= userRepository.findByUsername(username);
//                if(user == null)
//                   throw new UsernameNotFoundException("Invalid username or password.");
//                else
//                  return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapToGrantedAuthorities(user.getRoleList()));
//                
//        
//        
//     
//
//    }
    /*With customuser properties & actual user roles*/
    @Override
    public CustomUser  loadUserByUsername(String username) throws UsernameNotFoundException {
        
      
                Users  user= userRepository.findByUsername(username);
                if(user == null)
                   throw new UsernameNotFoundException("Invalid username or password.");
                else
                  return new CustomUser(user.getUserName(), user.getPassword(),user.isEnabled()==1?true:false,true,true,true, mapToGrantedAuthorities(user.getRoleList()),user.getFirstName(),user.getLastName());
                
        
        
     

    }
   private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
//      List<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
//       return grantedAuthoritiesList;
       return roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleName().name()))
                .collect(Collectors.toList());
       
       
    }
    
}
