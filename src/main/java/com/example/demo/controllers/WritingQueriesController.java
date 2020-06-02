/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.Business.services.WritingQueriesService;
import com.example.demo.daos.EmployeeRepository;
import com.example.demo.model.entities.dtos.EmployeeDto;
import com.example.demo.model.entities.dtos.ProductDto;
import com.example.demo.daos.specs.EmployeeSpecifications;
import com.example.demo.entities.Employees;
import com.example.demo.utils.DateUtilities;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class WritingQueriesController {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private WritingQueriesService writingQueriesService;
    
    //1-named queries
    @RequestMapping(value = "/getEmployeeByNameNamedQuery", method = RequestMethod.GET)
    public List<Employees> getByBirthDateGreater(@RequestParam("birthDate") String birthDate) {
        
            String datePattern = "yyyy-MM-dd";
            Date date = DateUtilities.convertStringToDate(datePattern, birthDate);
            return employeeRepository.getByBirthDateGreater(date);
        
            
    }
   //2-jpql
   @RequestMapping(value = "/getEmployeeByNameJpql", method = RequestMethod.GET)
    public List<Employees> getEmployeeByNameJpql(@RequestParam("name") String name) {
        
        return employeeRepository.getByEmployeeName(name);
        
    }
    //3-native sql 
   @RequestMapping(value = "/getByNativeQuery", method = RequestMethod.GET)
    public List<Employees> getEmployeeByNameNativeQuery(@RequestParam("name") String name) {
        
       return employeeRepository.getByEmployeeNamebNative(name);
    }
   //4-specs
    @RequestMapping(method = RequestMethod.GET,value = "/getAllEmployeesBySpecs")    
    public List<Employees> getAllEmployeesBySpecs(@RequestParam("name") String name,@RequestParam("entryDate") String entryDate) {
        
        String datePattern = "yyyy-MM-dd";
        Date date = DateUtilities.convertStringToDate(datePattern, entryDate);
        return employeeRepository.findAll(EmployeeSpecifications.findByEmployeeSpecs(name,date));
        
       
    }
    //4-specs & pagination
    @RequestMapping(method = RequestMethod.GET,value = "/getAllEmployeesBySpecsPage")    
    public List<Employees> getAllEmployeesBySpecsPage(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize,@RequestParam("name") String name,@RequestParam("entryDate") String entryDate) {
        
        String datePattern = "yyyy-MM-dd";
        Date date = DateUtilities.convertStringToDate(datePattern, entryDate);
        Page pageResult;
        Pageable pageable = PageRequest.of(page, pageSize);         
        pageResult= employeeRepository.findAll(EmployeeSpecifications.findByEmployeeSpecs(name,date),pageable);
        return  pageResult.getContent();
        
    }
    
    //
    @RequestMapping(value = "/getByJoinColumnAttribute", method = RequestMethod.GET)
    public List<Employees> getByJoinColumnAttribute(@RequestParam("name") String name) {
       return writingQueriesService.findAllEmployees(name);
       
    }
}
