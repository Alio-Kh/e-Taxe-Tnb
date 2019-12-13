/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 */
@Repository
public interface TerrainDao  extends   JpaRepository<Terrain, Long>{

     public List<Terrain> findByReferance(String referance);
//     public Terrain findById(Long id);
     public List<Terrain> findByCategorie(Categorie categorie);
     public List<Terrain> findByProprietaire(Proprietaire proprietaire);
     public List<Terrain> findBySurface(BigDecimal surface);

   
 
    
}
