/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.ProprietaireDao;
import com.fstg.eTaxe.Tnb.dao.TerrainDao;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Service
public class ProprietaireServiceImpl implements ProprietaireService {

    @Autowired
    private ProprietaireDao proprietaireDao;
    @Autowired
     private TerrainService terrainService;

    @Override
    public void save(Proprietaire proprietaire) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        proprietaireDao.save(proprietaire);
    }

    @Override
    public Proprietaire findByNom(String nom) {
        return proprietaireDao.findByNom(nom);
    }

    @Override
    public Proprietaire findByPrenom(String prenom) {
        return proprietaireDao.findByPrenom(prenom);
    }

    @Override
    public Proprietaire findByAdresse(String adresse) {
        return proprietaireDao.findByAdresse(adresse);
    }

    @Override
    public Proprietaire findByEmail(String email) {
        return proprietaireDao.findByEmail(email);
    }

    @Override
    public List<Proprietaire> findAll() {
        return proprietaireDao.findAll();
    }

    @Transactional
    @Override
    public void deleteProprietaire(Long id) {
        proprietaireDao.deleteById(id);
    }

    //(Ali)
    @Override
    public Proprietaire findById(Long id) {
        return proprietaireDao.findById(id).get();
    }

    @Override
    public Proprietaire findByReferance(String referance) {
        return proprietaireDao.findByReferance(referance);
    }
@Override
    public Proprietaire findPersonneNotifier(int n,long id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       //List<Proprietaire> proprietaires = null ;
        Terrain terrain= terrainService.findById(id);
        //for(int i=0;i<terrains.size();i++){
           // Terrain terrain1=terrains.get(i);
            if(terrain.getDarierNotification().getNumeroNotification()==n){
               return terrain.getProprietaire();
            }else{
                return null;
            }
    }

    @Override
    public List<Proprietaire> findPersonneNotifierr(int n) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Proprietaire>proprietaires=new ArrayList<Proprietaire>();
        List<Terrain> terrains =terrainService.findTerrainNotifier(n);
              for(Terrain terrain:terrains){
                  proprietaires.add(terrain.getProprietaire());
              }
        
              return proprietaires;
        
    }
    
}