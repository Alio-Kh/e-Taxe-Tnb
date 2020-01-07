/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author yassine
 */
public interface TauxTaxeService {
    
    public List<TauxTaxe> findAll();

    public void deletTauxTaxe(Long id);

    public void save(TauxTaxe tauxTaxe);

    public TauxTaxe findByCategorie(Categorie categorie);

    public TauxTaxe findByMontantTaxe(BigDecimal montantTaxe);

    public TauxTaxe findByDateDebut(Date dateDebut);

    public TauxTaxe findByDateFin(Date dateFin);

    public TauxTaxe update(TauxTaxe tauxTaxe);

    public TauxTaxe findById(Long id);
    
public TauxTaxe findByCategorieAndDateNow(Categorie categorie,Date dateNow);
}
