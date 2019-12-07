/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import java.math.BigDecimal;

/**
 *
 * @author yassine
 */
public interface TauxTaxeService {
   // public List<Terrain>  findAll();
    //public Terrain findByLibelle(String libelle);
    //public Terrain findByid(Long id);
    //public void deletTerrain(long id);
    public void save(TauxTaxe ttx);
    public TauxTaxe findBymontantTaxe(BigDecimal montant);
    
    
    
}
