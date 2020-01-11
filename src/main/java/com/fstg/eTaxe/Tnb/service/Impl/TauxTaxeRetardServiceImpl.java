/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxeRetard;
import com.fstg.eTaxe.Tnb.dao.TauxTaxeRetardDao;
import com.fstg.eTaxe.Tnb.service.CategorieService;
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

    @Autowired
    public CategorieService categorieService;

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
    public String update(long id, TauxTaxeRetard tauxTaxeRetard) {
        TauxTaxeRetard tauxTaxeRetard1 = findById(id);
        if (tauxTaxeRetard1 != null) {
            if (tauxTaxeRetard.getNombreMois() != 0) {
                tauxTaxeRetard1.setNombreMois(tauxTaxeRetard.getNombreMois());
            }
            if (tauxTaxeRetard.getTauxTaxeRetard() != null) {
                tauxTaxeRetard1.setTauxTaxeRetard(tauxTaxeRetard.getTauxTaxeRetard());
            }
            tauxTaxeRetardDao.save(tauxTaxeRetard1);
            return "taux retard taxe updated";
        }
        return "taux retard taxe not updated (il n'existe pas)";
    }

    @Override
    public TauxTaxeRetard findById(Long id) {
        return tauxTaxeRetardDao.findById(id).get();
    }

    @Override
    public String save(TauxTaxeRetard tauxTaxeRetard) {
        if (tauxTaxeRetardDao.existsByCategorie(categorieService.findById(tauxTaxeRetard.getCategorie().getId()))) {
            return "le taux taxe de la categorie "+categorieService.findById(tauxTaxeRetard.getCategorie().getId()).getLibelle()+" exist";
        } else {
            tauxTaxeRetardDao.save(tauxTaxeRetard);
            return "le taux taxe de la categorie "+categorieService.findById(tauxTaxeRetard.getCategorie().getId()).getLibelle()+"saved";
        }
    }

    @Override
    public TauxTaxeRetard findByTauxTaxeRetard(BigDecimal tauxTaxeRetard) {
        return tauxTaxeRetardDao.findByTauxTaxeRetard(tauxTaxeRetard);
    }

}
