/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.daos.EmployeeRepository;
import com.example.demo.model.entities.dtos.EmployeeDto;
import com.example.demo.security.daos.projection.EmployeeProjection;
import com.example.demo.daos.specs.EmployeeSpecifications;
import com.example.demo.entities.Employees;
import com.example.demo.utils.DateUtilities;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class ProjectionController {
    @Autowired
    private EmployeeRepository employeeRepository;
       
      
   //1-find all
   @RequestMapping(value = "/findAllEmployeeProjected", method = RequestMethod.GET)
    public List<EmployeeProjection> findAllEmployeeProjected() {
        
        return employeeRepository.findAllProjectedBy();
        
    }
    //1-find all by name projected
   @RequestMapping(value = "/findAllEmployeeProjectedByName", method = RequestMethod.GET)
    public List<EmployeeProjection> findAllEmployeeProjectedBy(@RequestParam("name") String name) {
        
        return employeeRepository.findAllProjectedByName(name);
        
    }
   
   //4-specs
    @RequestMapping(method = RequestMethod.GET,value = "/getAllEmployeesProjectedBySpecs")    
    public List<EmployeeDto> getAllEmployeesBySpecs(@RequestParam("name") String name,@RequestParam("entryDate") String entryDate) {
        
        String datePattern = "yyyy-MM-dd";
        Date date = DateUtilities.convertStringToDate(datePattern, entryDate);
        List<Employees> resultList = employeeRepository.findAll(EmployeeSpecifications.findByEmployeeSpecs(name,date));
         List<EmployeeDto> finalList=resultList.stream().map(p -> new EmployeeDto(p.getId(),p.getName(),p.getBirthDate(),p.getEmail())).collect(Collectors.toList());

        return finalList;
        
       
    }
    
    
}
