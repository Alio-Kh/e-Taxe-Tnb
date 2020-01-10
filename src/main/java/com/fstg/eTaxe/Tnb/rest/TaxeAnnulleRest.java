/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.TaxeAnnuelle;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.TerrainDao;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import com.fstg.eTaxe.Tnb.service.TaxeAnnuelleService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/e-Taxe-Tnb/taxe_annulle")
public class TaxeAnnulleRest {

    @Autowired // permet d'instensier un objet   // si il troveent beaucoup de class fille erreur 
    private TaxeAnnuelleService taxeAnnuelleService;

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private ProprietaireService proprietaireService;

    //tested(Ali)
    @GetMapping(value = "/annee/{annee}/referance/{referance}")
    public TaxeAnnuelle findByAnneeAndTerrainAndProprietaire(@PathVariable int annee, @PathVariable String referance) {
        return taxeAnnuelleService.findByAnneeAndTerrainAndProprietaire(annee, terrainService.findByReferance(referance), terrainService.findByReferance(referance).getProprietaire());
    }

    //tested(Ali)
    @PostMapping(value = "/")
    public void save(@RequestBody TaxeAnnuelle taxeAnnuelle) {
        taxeAnnuelleService.save(taxeAnnuelle);
    }

    //Hadi mab9atche khdama -_-
    //tested(ALi)********************(Non Complité)****************(+taxe retard)
//    @PutMapping(value = "/id/{id}")
//    public void updateMontant(@PathVariable Long id) {
//        TaxeAnnuelle taxeAnnuelle = new TaxeAnnuelle();
//        taxeAnnuelle = taxeAnnuelleService.findById(id);
//        taxeAnnuelle = taxeAnnuelleService.calculeMontant(taxeAnnuelle);
//        taxeAnnuelleService.save(taxeAnnuelle);
//    }
    //tested(Ali)
    @GetMapping(value = "/")
    public List<TaxeAnnuelle> findAll() {
        return taxeAnnuelleService.findAll();
    }

//    //tested(Ali)
//    @GetMapping(value = "/proprietaire/id/{id}")
//    public List<TaxeAnnuelle> taxesNonPayeeByProprietaire(@PathVariable Long id) {
//        return taxeAnnuelleService.taxesNonPayeeByProprietaire(proprietaireService.findById(id).get());
//    }
//
//    //tested(Ali)
//    @GetMapping(value = "/terrain/id/{id}")
//    public List<TaxeAnnuelle> taxesNonPayeeByTerrain(@PathVariable Long id) {
//        return taxeAnnuelleService.taxesNonPayeeByTerrain(terrainService.findById(id));
//    }
//
//    //tested(Ali)
//    @GetMapping(value = "/terrain/referance/{referance}")
//    public List<TaxeAnnuelle> findTaxesNonPayeeByReferanceTerrain(@PathVariable String referance) {
//        return taxeAnnuelleService.findTaxesNonPayeeByReferanceTerrain(terrainService.findByReferance(referance));
//    }
    //tested(Ali)
    @PutMapping(value = "/id/{id}")
    public void update(@PathVariable Long id) {
        taxeAnnuelleService.update(id);
    }
    //update2
//    @PutMapping(value = "/id/{id}")
//    public void calculeMontantRetard(@PathVariable Long id) {
//        taxeAnnuelleService.calculeMontantRetard(id);
//    }

//    @PutMapping(value = "/taxeAnnuelle/id/{id}")
//    public void calculeMontant(@PathVariable Long id) {
//        taxeAnnuelleService.calculeMontant(taxeAnnuelle);
//    }d
    
    @GetMapping("/terrain/annee/{annee}/id/{id}")
    public TaxeAnnuelle findByAnneeAndTerrain(@PathVariable int annee, @PathVariable long id) {
        return taxeAnnuelleService.findByAnneeAndTerrain(annee, terrainService.findById(id));
    }
}
