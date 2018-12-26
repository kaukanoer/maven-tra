/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.repository;

import com.spring.tra.entity.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kaukanoer
 */
public interface DivisiRepository extends JpaRepository<Divisions, String> {
    
}
