/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.daos;


import com.example.demo.security.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author rehab.abd-elhamid
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
   
   
    @Query("SELECT u FROM Users u WHERE UPPER(TRIM(u.userName))=UPPER(TRIM(:username))")
    public Users  findByUsername(@Param("username")String username);
   
}
