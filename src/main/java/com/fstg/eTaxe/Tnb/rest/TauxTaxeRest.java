/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import com.fstg.eTaxe.Tnb.service.CategorieService;
import com.fstg.eTaxe.Tnb.service.TauxTaxeService;
import com.fstg.eTaxe.Tnb.service.util.DateUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Autowired
    public CategorieService categorieService;

    //tested
    @GetMapping(value = "/")
    public List<TauxTaxe> findAll() {
        return tauxTaxeService.findAll();
    }

    //tested
    @DeleteMapping(value = "/id/{id}")
    public void deletTauxTaxe(@PathVariable Long id) {
        tauxTaxeService.deletTauxTaxe(id);
    }

    //tested
    @PostMapping(value = "/")
    public String save(@RequestBody TauxTaxe tauxTaxe) {
       return tauxTaxeService.save(tauxTaxe);
    }

    @GetMapping(value = "/categorie/")
    public TauxTaxe findByCategorie(@RequestBody Categorie categorie) {
        return tauxTaxeService.findByCategorie(categorie);
    }

    //tested
    @GetMapping(value = "/montantTaxe/{montantTaxe}")
    public List<TauxTaxe> findByMontantTaxe(@PathVariable BigDecimal montantTaxe) {
        return tauxTaxeService.findByMontantTaxe(montantTaxe);
    }

    @GetMapping(value = "/dateDebut/{dateDebut}")
    public TauxTaxe findByDateDebut(@PathVariable String dateDebut) {
        return tauxTaxeService.findByDateDebut(DateUtil.parse(dateDebut));
    }

//    @Query("select * from TauxTaxe where dateFin >=1")
//    @GetMapping(value="/dateFin/{dateFin}")
//    public TauxTaxe findByDateFin(@Param Date dateFin) {
//        return tauxTaxeService.findByDateFin(dateFin);
//    }
    @GetMapping(value = "/dateFin/{dateFin}")
    public TauxTaxe findByDateFin(@PathVariable String dateFin) {
        return tauxTaxeService.findByDateFin(DateUtil.parse(dateFin));
    }

    @GetMapping(value = "/id/{id}")
    public TauxTaxe findById(Long id) {
        return tauxTaxeService.findById(id);
    }

    //tested(Ali)
    @GetMapping(value = "/libelleCategorie/{libelleCategorie}")
    public TauxTaxe findByCategorieAndDateNow(@PathVariable String libelleCategorie) {
        return tauxTaxeService.findByCategorieAndDateNow(categorieService.findByLibelle(libelleCategorie));
    }
      
    //tested(Ali)
    @GetMapping(value = "/libelleCategorie/{libelleCategorie}/annee/{annee}")
    public TauxTaxe findByCategorieAndAnneeTaxe(@PathVariable String libelleCategorie, @PathVariable int annee){
        return tauxTaxeService.findByCategorieAndDateTaxe(categorieService.findByLibelle(libelleCategorie),  DateUtil.parseYearIntegerToDate(annee));
    }
    
   

}
