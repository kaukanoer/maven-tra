/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.controller;

import com.spring.tra.entity.Divisions;
import com.spring.tra.interfaces.DivisiInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kaukanoer
 */
@RestController
@RequestMapping("/division")
public class DivisiController {

    @Autowired
    DivisiInterface di;
    Divisions d;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("index");
        List<Divisions> div = di.getAll();
        mav.addObject("divisionList", div);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("divisionName") String namaDivisi) {
        ModelAndView mav = new ModelAndView("redirect:/division/list");
        if (id.isEmpty()) {
//            d.setId(String.valueOf(di.getAll().size() + 1));  
            d = new Divisions(String.valueOf(di.getAll().size() + 1), namaDivisi, "0");
        } else {
//            d.setId(id);
            d = new Divisions(id, namaDivisi, "0");

        }
//        d.setDivisi(namaDivisi);
//        d.setIsDelete("0");
//        d = new Divisions(id, namaDivisi, "0");
        di.saveorupdate(d);
        
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("field", di.getbyId(id));
        return mav;
    }
}
