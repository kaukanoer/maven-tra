/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.controller;

import com.spring.tra.entity.Accounts;
import com.spring.tra.entity.Requests;
import com.spring.tra.interfaces.RequestInterface;
import com.spring.tra.service.RequestService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kaukanoer
 */
@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    RequestInterface ri;
    RequestService rs;
    Requests request;
    Accounts account;

    /**
     * method untuk getAll Request
     *
     * @return
     */
    @RequestMapping(value = ("/"), method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("RequestList");
        List<Requests> div = ri.getAll();
        mav.addObject("requestList", div);
        return mav;
    }

    /**
     * Method untuk update request approve atau reject
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("RequestDetail");
        mav.addObject("field", ri.getbyId(id));
        return mav;
    }

    @RequestMapping(value = "/approval", method = RequestMethod.POST)
    public ModelAndView approval(@RequestParam("id") String id,
            @RequestParam("type") String type,
            @RequestParam("catatan") String catatan) {
        ModelAndView mav = new ModelAndView("redirect:/request/");
        Object object = ri.getbyId(id);
        Requests req = (Requests) object;

        account = new Accounts(req.getAccountNik().getNik());
        String keperluan = req.getKeperluan();
        String transportBerangkat = req.getTransportBerangkat();
        Date tanggalBerangkat = req.getTanggalBerangkat();
        String transportPulang = req.getTransportPulang();
        Date tanggalPulang = req.getTanggalPulang();
        String hotel = req.getHotel();
        Date cekkin = req.getCekIn();
        Date cekkout = req.getCekOut();
        if(catatan.isEmpty()){
            catatan =" - "; 
        }
        //approve
        if (type.equals("1")) {
            request = new Requests(id, keperluan, transportBerangkat, tanggalBerangkat, transportPulang, tanggalPulang, hotel, cekkin, cekkout, catatan, "Approved", "0", account);
        } //reject
        else {
            request = new Requests(id, keperluan, transportBerangkat, tanggalBerangkat, transportPulang, tanggalPulang, hotel, cekkin, cekkout, catatan, "Rejected", "0", account);
        }
        ri.saveorupdate(request);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id,
            @RequestParam("nik") String nik,
            @RequestParam("keperluan") String keperluan,
            @RequestParam("transportBerangkat") String transportBerangkat,
            @RequestParam("waktuBerangkat") String waktuBerangkat,
            @RequestParam("transportPulang") String transportPulang,
            @RequestParam("waktuPulang") String waktuPulang,
            @RequestParam("hotel") String hotel,
            @RequestParam("cekin") String cekin,
            @RequestParam("cekout") String cekout){
        ModelAndView mav = new ModelAndView("redirect:/request/");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        account = new Accounts(nik);
        
        try {
            Date tanggalBerangkat = format.parse(waktuBerangkat);
            Date tanggalPulang = format.parse(waktuPulang);
            Date cekkin = format.parse(cekin);
            Date cekkout = format.parse(cekout);
            //create request baru
            if (id.isEmpty()) {
                request = new Requests(String.valueOf(ri.getAll().size() + 1), keperluan, transportBerangkat, tanggalBerangkat, transportPulang, tanggalPulang, hotel, cekkin, cekkout, " - ", "Waiting", "0", account);
            } 
            //update
            else {
                request = new Requests(id, keperluan, transportBerangkat, tanggalBerangkat, transportPulang, tanggalPulang, hotel, cekkin, cekkout, " - ", "Waiting", "0", account);
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }
        ri.saveorupdate(request);
        return mav;
    }
}
