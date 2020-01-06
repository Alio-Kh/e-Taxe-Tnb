/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxeRetard;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface TauxTaxeRetardDao extends JpaRepository<TauxTaxeRetard, Long> {

    public TauxTaxeRetard findByCategorie(Categorie categorie);

    public TauxTaxeRetard findByTauxTaxeRetard(BigDecimal tauxTaxeRetard);

}
