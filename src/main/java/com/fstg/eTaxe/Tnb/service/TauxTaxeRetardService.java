/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import com.fstg.eTaxe.Tnb.bean.TauxTaxeRetard;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface TauxTaxeRetardService {

    public List<TauxTaxeRetard> findAll();

    public void deletTauxTaxeRetard(Long id);

    public void save(TauxTaxeRetard tauxTaxeRetard);

    public TauxTaxeRetard findByCategorie(Categorie categorie);

    public TauxTaxeRetard findByTauxTaxeRetard(BigDecimal tauxTaxeRetard);

    public TauxTaxeRetard update(TauxTaxeRetard tauxTaxeRetard);

    public TauxTaxeRetard findById(Long id);

}
