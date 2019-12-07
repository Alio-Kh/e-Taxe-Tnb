/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;


import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.TerrainDao;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Service
public class TerrainServiceImpl implements TerrainService {

    @Autowired
    private TerrainDao terraindao;// pas de classe qui va implemente cette classe(Dao) c'est automatiquement jSpring data qui va fournir ca 
    // si il troveent beaucoup de class fille erreur 

    @Override
    public void save(Terrain terrain) {
        terraindao.save(terrain);
    }

    @Override
    public List<Terrain> findAll() {
        return terraindao.findAll();
    }

  
    

    @Transactional
    @Override
    public void deletTerrain(long id) {
        terraindao.deleteById(id);

    }

    @Override
    public Terrain findByid(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return  terraindao.findByid(id);
    }

    @Override
    public List<Terrain> findByLibelle(String libelle) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Terrain> resulta=new ArrayList<Terrain>();
        
         return  terraindao.findByLibelle(libelle);
    }

    @Override
    public List<Terrain> findByCategorie(Categorie categorie) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           return  terraindao.findByCategorie(categorie);
        
    }

    @Override
    public List<Terrain> findByPropreitaire(Proprietaire proprietaire) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return  terraindao.findByPropreitaire(proprietaire);
    }

    @Override
    public List<Terrain> findBySurface(BigDecimal surface) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
