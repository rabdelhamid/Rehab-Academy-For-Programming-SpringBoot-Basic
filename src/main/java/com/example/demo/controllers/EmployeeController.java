/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.daos.EmployeeRepository;
import com.example.demo.model.entities.dtos.EmployeeDto;
import com.example.demo.model.entities.dtos.ProductDto;
import com.example.demo.entities.Employees;
import com.example.demo.utils.DateUtilities;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    
    @RequestMapping(method = RequestMethod.GET,value = "/getAllEmployees")    
    public List<Employees> getAllEmployees() {
        
        return employeeRepository.findAll();
    }
    
    @RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
    public Employees getProductDetails(@RequestParam("empId") int empId) {
        
        Optional<Employees> opEmployee=employeeRepository.findById(empId);
        if(opEmployee.isPresent())
          return opEmployee.get();
        else
            return null;
    }
    
   
    
    @RequestMapping(method = RequestMethod.GET,value = "/getEmployeeByNameLike")    
    public List<Employees> getEmployeeByNameLike(@RequestParam("name") String name) {
        return employeeRepository.findAllByNameLike(name);
    }
   
    @RequestMapping(method = RequestMethod.GET,value = "/findAllEmployeesByDateGreaterThan")    
    public List<Employees> getEmployeeByEntryDate(@RequestParam("entryDate") String entryDate) {
        String datePattern = "yyyy-MM-dd";
        Date date = DateUtilities.convertStringToDate(datePattern, entryDate);
        return employeeRepository.findAllByEntryDateGreaterThan(date);
    }
    
}
