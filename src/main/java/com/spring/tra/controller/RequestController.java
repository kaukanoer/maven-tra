/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.controller;

import com.spring.tra.iface.RequestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kaukanoer
 */
@Controller
public class RequestController {
    @Autowired
    RequestInterface ri;
    
    @RequestMapping("/request")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("requestList", ri.findAll());
        return mav;
    }
    
}
