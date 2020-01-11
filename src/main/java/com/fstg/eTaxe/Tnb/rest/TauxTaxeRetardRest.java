/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxeRetard;
import com.fstg.eTaxe.Tnb.bean.TaxeAnnuelle;
import com.fstg.eTaxe.Tnb.service.TauxTaxeRetardService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alikhyatti
 */

@RestController
@RequestMapping("/e-Taxe-Tnb/taux_taxe_Retard")
public class TauxTaxeRetardRest {

    @Autowired
    public TauxTaxeRetardService tauxTaxeRetardService;

    //not tested
    @GetMapping(value = "/")
    public List<TauxTaxeRetard> findAll() {
        return tauxTaxeRetardService.findAll();
    }

    //not tested
    @DeleteMapping(value = "/id/{id}")
    public void deletTauxTaxe(@PathVariable Long id) {
        tauxTaxeRetardService.deletTauxTaxeRetard(id);
    }

    //not tested
    @PostMapping(value = "/")
    public String save(@RequestBody TauxTaxeRetard tauxTaxeRetard) {
        return tauxTaxeRetardService.save(tauxTaxeRetard);
    }

    @GetMapping(value = "/categorie/")
    public TauxTaxeRetard findByCategorie(@RequestBody Categorie categorie) {
        return tauxTaxeRetardService.findByCategorie(categorie);
    }

    //
    @GetMapping(value = "/montantTaxe/{montantTaxe}")
    public TauxTaxeRetard findByMontantTaxe(@PathVariable BigDecimal tauxTaxeRetard) {
        return tauxTaxeRetardService.findByTauxTaxeRetard(tauxTaxeRetard);
    }

    @GetMapping(value = "/id/{id}")
    public TauxTaxeRetard findById(@PathVariable Long id) {
        return tauxTaxeRetardService.findById(id);
    }
    
    @PutMapping("/id/{id}")
    public String update(@PathVariable long id, @RequestBody TauxTaxeRetard tauxTaxeRetard){
        return tauxTaxeRetardService.update(id, tauxTaxeRetard);
    }


}
