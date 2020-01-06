/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.dao.QuartierDao;
import com.fstg.eTaxe.Tnb.service.QuartierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class QuartierServiceImpl implements QuartierService {

    @Autowired
    private QuartierDao quartierDao;

    @Override
    public Quartier findByLibelle(String libelle) {
        return getQuartierDao().findByLibelle(libelle);
    }

//    @Override
//    public Quartier findByRue(Rue rue) {
//        return quartierDao.findByRue(rue);
//    }
//    @Override
//    public List<Quartier> findBySecteur(Secteur secteur) {
//        return quartierDao.findBySecteur(secteur);
//    }
    @Override
    public void save(Quartier quartier) {
        getQuartierDao().save(quartier);
    }

    @Override
    public void deleteQuartier(long id) {
        getQuartierDao().deleteById(id);
    }

    @Override
    public List<Quartier> findAll() {
        return getQuartierDao().findAll();
    }

    /**
     * @return the quartierDao
     */
    public QuartierDao getQuartierDao() {
        return quartierDao;
    }

    /**
     * @param quartierDao the quartierDao to set
     */
    public void setQuartierDao(QuartierDao quartierDao) {
        this.quartierDao = quartierDao;
    }

    @Override
    public int exitsts(long id) {
        if (quartierDao.existsById(id)) {
            return 1;
        } else {
            return 0;
        }
    }

}
