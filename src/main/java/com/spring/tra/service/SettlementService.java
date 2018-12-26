/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.service;

import com.spring.tra.entity.Settlements;
import com.spring.tra.interfaces.SettlementInterface;
import com.spring.tra.repository.SettlementRepository;
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
public class SettlementService implements SettlementInterface {

    @Autowired
    SettlementRepository sr;

    @Override
    public List<Settlements> getAll() {
        return (List<Settlements>) sr.findAll();
    }

    @Override
    public void saveorupdate(Settlements s) {
        sr.save(s);
    }

}
