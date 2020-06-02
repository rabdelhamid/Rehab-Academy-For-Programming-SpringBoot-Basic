/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.daos;

import com.example.demo.security.daos.projection.EmployeeProjection;
import com.example.demo.daos.specs.EmployeeSpecifications;
import com.example.demo.entities.Employees;
import com.example.demo.security.entities.Users;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>, JpaSpecificationExecutor{
    public List<Employees> findAllByNameLike(String Name);
    public List<Employees> findAllByEntryDateGreaterThan(Date entryDate);
    
    //writing queries
    //1-named query
    public List<Employees>  getByBirthDateGreater (Date birthDate);
    //2-jpql
    @Query("FROM Employees e WHERE UPPER(TRIM(e.name))=UPPER(TRIM(:employeeName))")    
    public List<Employees>  getByEmployeeName (@Param("employeeName")String employeeName);
    
    //3-Native
    @Query(value="SELECT * FROM EMPLOYEES e WHERE UPPER(TRIM(e.name))=UPPER(TRIM(:employeeName))",nativeQuery = true)    
    public List<Employees>  getByEmployeeNamebNative (@Param("employeeName")String employeeName);
    
    //4-specs
    
    //projection
    public List<EmployeeProjection> findAllProjectedBy();
    public List<EmployeeProjection> findAllProjectedByName(String name);
   // public List<EmployeeProjection> findAllProjectedBy(Specification<Employees> specs);
    
    //Naming Convention By Join Column
     public List<Employees> findAllByEmploymentTypeIdName(String Name);
}
