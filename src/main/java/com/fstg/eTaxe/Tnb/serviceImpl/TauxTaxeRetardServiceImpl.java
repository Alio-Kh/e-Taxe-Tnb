/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.serviceImpl;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxeRetard;
import com.fstg.eTaxe.Tnb.dao.TauxTaxeRetardDao;
import com.fstg.eTaxe.Tnb.service.TauxTaxeRetardService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikhyatti
 */
@Service
public class TauxTaxeRetardServiceImpl implements TauxTaxeRetardService {

    @Autowired
    public TauxTaxeRetardDao tauxTaxeRetardDao;

    @Override
    public List<TauxTaxeRetard> findAll() {
        return tauxTaxeRetardDao.findAll();
    }

    @Override
    public void deletTauxTaxeRetard(Long id) {
        tauxTaxeRetardDao.deleteById(id);
    }

    @Override
    public TauxTaxeRetard findByCategorie(Categorie categorie) {
        return tauxTaxeRetardDao.findByCategorie(categorie);
    }

//    @Override
//    public TauxTaxeRetard findByMontantTaxeRetard(BigDecimal montantTaxeRetard) {
//        return tauxTaxeRetardDao.findByMontantTaxeRetard(montantTaxeRetard);
//    }
    // not implemented yet
    @Override
    public TauxTaxeRetard update(TauxTaxeRetard tauxTaxeRetard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TauxTaxeRetard findById(Long id) {
        return tauxTaxeRetardDao.findById(id).get();
    }

    @Override
    public void save(TauxTaxeRetard tauxTaxeRetard) {
        tauxTaxeRetardDao.save(tauxTaxeRetard);
    }

    @Override
    public TauxTaxeRetard findByTauxTaxeRetard(BigDecimal tauxTaxeRetard) {
        return tauxTaxeRetardDao.findByTauxTaxeRetard(tauxTaxeRetard);
    }

}
