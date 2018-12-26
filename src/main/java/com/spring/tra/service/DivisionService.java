/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.service;

import com.spring.tra.entity.Divisions;
import com.spring.tra.interfaces.DivisiInterface;
import com.spring.tra.repository.DivisiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kaukanoer
 */
@Service
@Transactional
public class DivisionService implements DivisiInterface {

    @Autowired
    DivisiRepository di;

    @Override
    public List<Divisions> getAll() {
        return (List<Divisions>) di.findAll();
    }

    @Override
    public void saveorupdate(Divisions divisi) {
        di.save(divisi);
    }

    @Override
    public Divisions getbyId(String id) {
        return di.findById(id).get();
    }
}
