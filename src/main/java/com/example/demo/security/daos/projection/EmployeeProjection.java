/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.daos.projection;

import java.util.Date;

/**
 *
 * @author rehab.abd-elhamid
 */
//https://github.com/spring-projects/spring-data-examples/blob/master/jpa/example/src/main/java/example/springdata/jpa/projections/CustomerProjection.java
public interface  EmployeeProjection {
    
    String getName();
    String getEmail();
    Date getBirthDate();
    
}
