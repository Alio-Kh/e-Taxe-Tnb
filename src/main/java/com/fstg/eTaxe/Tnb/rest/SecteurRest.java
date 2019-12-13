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

    //tested
    @GetMapping(value="/libelle/{libelle}")
    public Secteur findByLibelle(@PathVariable String libelle) {
        return secteurService.findByLibelle(libelle);
    }
    
    // tested
    @GetMapping(value="/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }
    
    //tested
    @PostMapping(value="/")
    public void save(@RequestBody Secteur secteur) {
        secteurService.save(secteur);
    }
    
    //tested
    @DeleteMapping(value="/id/{id}")
    public void deleteSecteur(@PathVariable long id) {
        secteurService.deleteSecteur(id);
    }
    
}
