/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.serviceImpl;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.bean.Rue;
import com.fstg.eTaxe.Tnb.dao.RueDao;
import com.fstg.eTaxe.Tnb.service.RueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class RueServiceImpl implements RueService {
    
    @Autowired
    public RueDao rueDao;
    
    @Override
    public Rue findByLibelle(String libelle) {
        return rueDao.findByLibelle(libelle);
    }
    
//    @Override
//    public List<Rue> findByQuartier(Quartier quartier) {
//        return rueDao.findByQuartier(quartier);
//    }
//    
    @Override
    public List<Rue> findAll() {
        return rueDao.findAll();
    }
    
    @Override
    public void save(Rue rue) {
        rueDao.save(rue);
    }
    
    @Override
    public void deleteRue(long id) {
        rueDao.deleteById(id);
    }
    
}
