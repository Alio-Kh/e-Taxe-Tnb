/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.bean.Rue;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface RueService {

    public Rue findByLibelle(String libelle);

//    public List<Rue> findByQuartier(Quartier quartier);
    
    // yassin
    public List<Rue> findAll();

    public void save(Rue rue);
    public Rue findByid(long id);
    public void deleteRue(long id);
    public List<Rue> findByIdQuartier( long idquartier);
    
    
   
    public List<Rue> findByLibelleQuartier(String libelleQuartie);
    
    public Rue WhereTerrainExist(long idTerrain);

}
