/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.service;

import com.spring.tra.entity.Requests;
import com.spring.tra.interfaces.RequestInterface;
import com.spring.tra.repository.RequestRepository;
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
public class RequestService implements RequestInterface {

    @Autowired
    RequestRepository rr;

    @Override
    public List<Requests> getAll() {
        return (List<Requests>) rr.findAll();
    }

    @Override
    public void saveorupdate(Requests r) {
        rr.save(r);
    }

    @Override
    public Requests getbyId(String id) {
        return rr.findById(id).get();
    }

}
