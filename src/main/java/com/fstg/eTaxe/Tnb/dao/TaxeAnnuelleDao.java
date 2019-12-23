/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.TaxeAnnuelle;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 */
@Repository
public interface TaxeAnnuelleDao  extends   JpaRepository<TaxeAnnuelle, Long>{
    
  public TaxeAnnuelle findByAnneeAndTerrainAndProprietaire(int annee, Terrain Terrain, Proprietaire proprietaire);
    
  
    
}
