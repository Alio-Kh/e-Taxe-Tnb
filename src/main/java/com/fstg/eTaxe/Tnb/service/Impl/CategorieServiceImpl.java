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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    public CategorieDao categoriDao;

    @Override
    public void save(Categorie categorie) {
        categoriDao.save(categorie);
    }

    @Override
    public Categorie findByLibelle(String libelle) {
        return categoriDao.findByLibelle(libelle);
    }

    @Override
    public Categorie findById(Long id) {
        return categoriDao.findById(id).get();
    }
    
    @Override
    public List<Categorie> findAll() {
        return categoriDao.findAll();
    }

    @Transactional
    @Override
    public void deleteCategorie(long id) {
        categoriDao.deleteById(id);
    }

    
    
    
    
}
