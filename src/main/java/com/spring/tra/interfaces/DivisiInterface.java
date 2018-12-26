/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.interfaces;

import com.spring.tra.entity.Divisions;
import java.util.List;

/**
 *
 * @author Kaukanoer
 */
public interface DivisiInterface {
    public List<Divisions> getAll();
    public void saveorupdate(Divisions divisi);
    public Divisions getbyId (String id);
}
