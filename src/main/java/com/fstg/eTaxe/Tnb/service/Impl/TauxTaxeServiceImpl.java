/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

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
    public TauxTaxe findByCategorie(Categorie categorie) {
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

    @Override
    public TauxTaxe findById(Long id) {
        return tauxTaxeDao.findById(id).get();
    }

    //(Ali)
    @Override
    public TauxTaxe findByCategorieAndDateNow(Categorie categorie, Date dateNow) {
        return tauxTaxeDao.findByCategorieAndDateNow(categorie, dateNow);
    }

    //test(Ali)
    @Override
    public TauxTaxe findByCategorieAndDateTaxe(Categorie categorie, Date dateTaxe) {
        return tauxTaxeDao.findByCategorieAndDateTaxe(categorie, dateTaxe);
    }
// not tested (yassine)
    @Override
    public int saveTaxe(TauxTaxe tauxTaxe) {
        Boolean isBetween1,isBetween2;
        List<TauxTaxe> tauxTaxes=findAll();
        for(TauxTaxe tauxTaxe1 :tauxTaxes){
         isBetween1=tauxTaxe.getDateDebut().after(tauxTaxe1.getDateDebut()) && tauxTaxe.getDateDebut().before(tauxTaxe1.getDateFin()) ;
         isBetween2=tauxTaxe.getDateFin().before(tauxTaxe1.getDateFin()) && (tauxTaxe.getDateFin().after(tauxTaxe1.getDateDebut()));
         if(isBetween1==false && isBetween2 == false ){
             tauxTaxeDao.save(tauxTaxe);
             return 1;
         } 
         }
        return -1;
        
    }

}
