/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.serviceImpl;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import com.fstg.eTaxe.Tnb.dao.TauxTaxeDao;
import com.fstg.eTaxe.Tnb.service.TauxTaxeService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class TauxTaxeServiceImpl implements TauxTaxeService {

    @Autowired
    public TauxTaxeDao tauxTaxeDao;

    @Override
    public List<TauxTaxe> findAll() {
        return tauxTaxeDao.findAll();
    }

    @Override
    public void deletTauxTaxe(Long id) {
        tauxTaxeDao.deleteById(id);
    }

    @Override
    public void save(TauxTaxe tauxTaxe) {
        tauxTaxeDao.save(tauxTaxe);
    }

    @Override
    public List<TauxTaxe> findByCategorie(Categorie categorie) {
        return tauxTaxeDao.findByCategorie(categorie);
    }

    @Override
    public TauxTaxe findByMontantTaxe(BigDecimal montantTaxe) {
        return tauxTaxeDao.findByMontantTaxe(montantTaxe);
    }

    @Override
    public TauxTaxe findByDateDebut(Date dateDebut) {
        return tauxTaxeDao.findByDateDebut(dateDebut);
    }

    @Override
    public TauxTaxe findByDateFin(Date dateFin) {
        return tauxTaxeDao.findByDateFin(dateFin);
    }

    
    
    
    
    
    // not implemented yet
    @Override
    public TauxTaxe update(TauxTaxe tauxTaxe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
