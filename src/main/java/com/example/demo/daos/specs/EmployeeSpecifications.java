/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.daos.specs;



import com.example.demo.entities.Employees;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import com.example.demo.entities.Employees_;

/**
 *
 * @author rehab.abd-elhamid
 */
public abstract class EmployeeSpecifications {

    public static Specification<Employees> findByEmployeeSpecs(String name,Date entryDate) {


        return (Root<Employees> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.like((root.get(Employees_.name)),"%"+name+"%")); 
           
            predicates.add(cb.lessThan(root.get(Employees_.entryDate), entryDate)); 
//         
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));

        };
    }
}
