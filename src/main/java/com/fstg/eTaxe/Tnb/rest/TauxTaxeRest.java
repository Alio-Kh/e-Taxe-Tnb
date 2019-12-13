/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import com.fstg.eTaxe.Tnb.service.TauxTaxeService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yassine
 */
@RestController
@RequestMapping("/e-Taxe-Tnb/taux_taxe")
public class TauxTaxeRest {
    
    @Autowired
    public TauxTaxeService tauxTaxeService;
    
    @GetMapping(value="/")
    public List<TauxTaxe> findAll() {
        return tauxTaxeService.findAll();
    }
    
    @DeleteMapping(value="/id/{id}")
    public void deletTauxTaxe(@PathVariable Long id) {
        tauxTaxeService.deletTauxTaxe(id);
    }
    
    @PostMapping(value="/")
    public void save(@RequestBody TauxTaxe tauxTaxe) {
        tauxTaxeService.save(tauxTaxe);
    }
    
    @GetMapping(value="/categorie/")
    public List<TauxTaxe> findByCategorie(@RequestBody Categorie categorie) {
        return tauxTaxeService.findByCategorie(categorie);
    }
    
    @GetMapping(value="/montant_taxe/{montant_taxe}")
    public TauxTaxe findByMontantTaxe(@PathVariable BigDecimal montantTaxe) {
        return tauxTaxeService.findByMontantTaxe(montantTaxe);
    }
    
    @GetMapping(value="/date_debut/{date_debut}")
    public TauxTaxe findByDateDebut(@PathVariable Date dateDebut) {
        return tauxTaxeService.findByDateDebut(dateDebut);
    }
    
    @GetMapping(value="/date_Fin/{date_Fin}")
    public TauxTaxe findByDateFin(@PathVariable Date dateFin) {
        return tauxTaxeService.findByDateFin(dateFin);
    }
}
