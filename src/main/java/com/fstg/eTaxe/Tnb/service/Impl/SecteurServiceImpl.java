/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.bean.Secteur;
import com.fstg.eTaxe.Tnb.dao.SecteurDao;
import com.fstg.eTaxe.Tnb.service.QuartierService;
import com.fstg.eTaxe.Tnb.service.SecteurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Service
public class SecteurServiceImpl implements SecteurService {
    
   
    @Autowired
    public SecteurDao secteurDao;
    @Autowired
    private QuartierService quartierService;
//    @Autowired
//    private SecteurService secteurService;

    @Override
    public Secteur findByLibelle(String libelle) {
        return secteurDao.findByLibelle(libelle);
    }
    
    @Override
    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }
    
    @Override
    public int saveAndTestExisting(Secteur secteur) {
        int rep;
        rep=existByLibelle(secteur.getLibelle());
        if(rep==1){
            secteurDao.save(secteur);
            return 1;
        }
     
            return -1;
    }

   
    @Override
    public int deleteSecteur(long id) {
            Secteur secteur=findByid(id);
            for(Quartier quartier :secteur.getQuartiers()){
                if (quartier==null){
                    secteurDao.deleteById(id);
                   return 1;
                }
            } return -1;
            
        }
       
       
    

    @Override
    public Secteur WhereDistricExiste(long idQuartier) {
        Quartier quartier =quartierService.findByid(idQuartier);
        return quartier.getSecteur();
    }

    @Override
    public int exitstsByid(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (secteurDao.existsById(id)) {
            return 1;
        } else {
            return 0;
        }
    }
    //already tested
    @Override
    public int existByLibelle(String libelle) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Secteur> secteurs =findAll();
        for(Secteur secteur:secteurs){
            if(secteur.getLibelle().equalsIgnoreCase(libelle)){
                return -1;
            }
        }
                return 1;
            }

    @Override
    public Secteur findByid(long id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.4return 
       return secteurDao.findByid(id);
    }
    @Transactional
    @Override
    public void deleteByid(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        secteurDao.deleteById(id);
    }
     
}
