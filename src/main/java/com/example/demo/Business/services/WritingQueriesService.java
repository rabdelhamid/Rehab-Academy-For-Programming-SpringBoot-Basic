/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Business.services;

import com.example.demo.daos.EmployeeRepository;
import com.example.demo.entities.Employees;
import com.example.demo.model.entities.dtos.ProductDto;
import java.util.List;
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
public class WritingQueriesService {
    
      @Autowired
    private EmployeeRepository employeeRepository;
    
    
     public List<Employees> findAllEmployees(String employmentTypeName) {         
        return employeeRepository.findAllByEmploymentTypeIdName(employmentTypeName);
     }
}
