/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.dao.ProprietaireDao;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author yassine
 */
@Service
public class ProprietaireServiceImpl implements  ProprietaireService{
    
    
    @Autowired
    private  ProprietaireDao prodao;
    @Override
    public void save(Proprietaire pr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        prodao.save(pr);
    }

    @Override
    public void findByid(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        prodao.findById(id);
    }
    
    
    
}
