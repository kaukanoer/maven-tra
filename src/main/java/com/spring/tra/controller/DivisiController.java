/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.controller;

import com.spring.tra.entity.Divisions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring.tra.iface.DivisiInterface;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kaukanoer
 */
@Controller
public class DivisiController {
    @Autowired 
    DivisiInterface di;
    
    @RequestMapping("/divisi")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("divisionList", di.findAll());
        return mav;
    }
    
    @RequestMapping(value = "/addDivision", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("divisionName")String namaDivisi){
        ModelAndView mav = new ModelAndView("redirect:/divisi");
        Divisions d = new Divisions("7", namaDivisi, "0");
        di.save(d);
        return mav;        
    }
    
    @RequestMapping(value = "/deleteDivision/{id}", method = RequestMethod.GET)
    public ModelAndView delete (@RequestParam("id") String id){
        ModelAndView mav = new ModelAndView("redirect:/divisi");
        di.delete(new Divisions(id));
        return mav;
    }
}
