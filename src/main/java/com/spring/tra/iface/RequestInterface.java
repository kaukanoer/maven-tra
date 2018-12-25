/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.iface;

import com.spring.tra.entity.Requests;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kaukanoer
 */
public interface RequestInterface extends CrudRepository<Requests, String> {
    
}
