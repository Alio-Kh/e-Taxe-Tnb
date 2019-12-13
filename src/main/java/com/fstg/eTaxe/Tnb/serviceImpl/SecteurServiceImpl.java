/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.serviceImpl;

import com.fstg.eTaxe.Tnb.bean.Secteur;
import com.fstg.eTaxe.Tnb.dao.SecteurDao;
import com.fstg.eTaxe.Tnb.service.SecteurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class SecteurServiceImpl implements SecteurService {
    
    @Autowired
    public SecteurDao secteurDao;

    @Override
    public Secteur findByLibelle(String libelle) {
        return secteurDao.findByLibelle(libelle);
    }
    
    @Override
    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }
    
    @Override
    public void save(Secteur secteur) {
        secteurDao.save(secteur);
    }
    
    @Override
    public void deleteSecteur(long id) {
        secteurDao.deleteById(id);
    }
    
}
