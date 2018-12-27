/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.interfaces;

import com.spring.tra.entity.Requests;
import java.util.List;

/**
 *
 * @author Kaukanoer
 */
public interface RequestInterface {
    public List<Requests> getAll();
    public void saveorupdate(Requests r);
    public Requests getbyId (String id);
}
