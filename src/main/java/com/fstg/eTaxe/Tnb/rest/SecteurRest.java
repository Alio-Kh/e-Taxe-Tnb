/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Secteur;
import com.fstg.eTaxe.Tnb.service.SecteurService;
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
@RequestMapping("/e-Taxe-Tnb/secteur")
@RestController
public class SecteurRest {
    @Autowired
    public SecteurService secteurService;

    // already testtest
    @GetMapping(value="/libelle/{libelle}")
    public Secteur findByLibelle(@PathVariable String libelle) {
        return secteurService.findByLibelle(libelle);
    }
    
    // already test test
    @GetMapping(value="/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }
    
    // already test 
    @PostMapping(value="/")
    public void saveAndTestExisting(@RequestBody Secteur secteur) {
        secteurService.saveAndTestExisting(secteur);
    }
    
    // already test test
    @DeleteMapping(value="/id/{id}")
    public void deleteSecteur(@PathVariable long id) {
        secteurService.deleteSecteur(id);
    }
    // ou existe une quartier ==> dans quelle secteur 
    // already test
    @GetMapping("/idQuartier/{idQuartier}")
    public Secteur WhereDistricExiste( @PathVariable long idQuartier) {
        return secteurService.WhereDistricExiste(idQuartier);
    }
    // already tested
  @GetMapping("/exist/{id}")
    public int exitstsByid(@PathVariable long id) {
        return secteurService.exitstsByid(id);
    }
    // already test
   @GetMapping("/existBylibelle/{libelle}")
    public int existByLibelle( @PathVariable String libelle) {
        return secteurService.existByLibelle(libelle);
    }
  @DeleteMapping("delete/{id}")
    public void deleteByid( @PathVariable long id) {
        secteurService.deleteByid(id);
    }
    
  
    
    
}
