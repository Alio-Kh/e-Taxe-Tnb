/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Rue;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.QuartierDao;
import com.fstg.eTaxe.Tnb.dao.RueDao;
import com.fstg.eTaxe.Tnb.service.QuartierService;
import com.fstg.eTaxe.Tnb.service.RueService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class RueServiceImpl implements RueService {
    
   @Autowired
    public RueDao rueDao;
    @Autowired
     QuartierService quartier;
    @Autowired
     private QuartierDao quartierDao;
    @Autowired
    private TerrainService terrainService;
     
    @Override
    public Rue findByLibelle(String libelle) {
        return rueDao.findByLibelle(libelle);
    }
    
//    @Override
//    public List<Rue> findByQuartier(Quartier quartier) { 
//        return rueDao.findByQuartier(quartier);
//    }
//    
    @Override
    public List<Rue> findAll() {
        return rueDao.findAll();
    }
    
    @Override
    public void  save(Rue rue) {
            //quartier.save(rue.getQuartier());
            rueDao.save(rue);

    }
    
    
    @Override
    public void deleteRue(long id) {
        rueDao.deleteById(id);
    }

    @Override
    public List<Rue> findByIdQuartier(long idquartier) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rueDao.findByIdQuartier(idquartier);
    }

    @Override
    public List<Rue> findByLibelleQuartier(String libelleQuartie) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return rueDao.findByLibelleQuartier(libelleQuartie);
    }

    @Override
    public Rue findByid(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rueDao.findByid(id);
    }

    @Override
    public Rue WhereTerrainExist(long idTerrain) {
        Terrain terrain =terrainService.findById(idTerrain);
        if(terrain==null){
            return null;
        }
            else{
                    return terrain.getRue();
                 }
        } 
}
