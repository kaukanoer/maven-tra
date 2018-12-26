/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.service;

import com.spring.tra.entity.Accounts;
import com.spring.tra.interfaces.AccountInterface;
import com.spring.tra.repository.AccountRepository;
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
public class AccountService implements AccountInterface {

    @Autowired
    AccountRepository ar;

    @Override
    public List<Accounts> getAll() {
        return (List<Accounts>) ar.findAll();
    }

    @Override
    public void saveorupdate(Accounts account) {
        ar.save(account);
    }
}
