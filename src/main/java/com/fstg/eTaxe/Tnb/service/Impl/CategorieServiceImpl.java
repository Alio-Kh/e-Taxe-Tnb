/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.dao.CategorieDao;
import com.fstg.eTaxe.Tnb.service.CategorieService;
import java.util.List;

/**
 *
 * @author yassine
 */
public class CategorieServiceImpl implements  CategorieService {
    private CategorieDao categoriDao;

    @Override
    public void save(Categorie categorie) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        categoriDao.save(categorie);
    }

    @Override
    public Categorie findBylibelle(String libelle) {
        return categoriDao.findBylibelle(libelle);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> findAll() {
       return  categoriDao.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
