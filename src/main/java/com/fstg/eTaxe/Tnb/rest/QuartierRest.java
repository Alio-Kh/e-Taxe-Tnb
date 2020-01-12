/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.service.QuartierService;
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
@RestController
@RequestMapping("/e-Taxe-Tnb/quartier")
public class QuartierRest {

    @Autowired
    private  QuartierService quartierService;
    @Autowired
    private SecteurService service;

    
    @GetMapping(value ="/libelle/{libelle}")
    public Quartier findByLibelle(@PathVariable String libelle) {
        return quartierService.findByLibelle(libelle);
    }

//    @GetMapping(value = "/rue/")
//    public Quartier findByRue(@RequestBody Rue rue) {
//        return quartierService.findByRue(rue);
//    }

//    @GetMapping(value = "/secteur/")
//    public List<Quartier> findBySecteur(@RequestBody Secteur secteur) {
//        return quartierService.findBySecteur(secteur);
//    }

    //tested
    @PostMapping(value = "/")
    public void save(@RequestBody Quartier quartier) {
        service.saveAndTestExisting(quartier.getSecteur());
        quartierService.save(quartier);
    }

    //tested
    @DeleteMapping(value = "/id/{id}")
    public void deleteQuartier(@PathVariable long id) {
        quartierService.deleteQuartier(id);
    }

    //tested
    @GetMapping(value = "/")
    public List<Quartier> findAll() {
        return quartierService.findAll();
    }
    // tested
   @GetMapping(value="/pff")
    public List<Quartier> findbySecteur() {
        return quartierService.findSecteur();
    }
  // already test
    @GetMapping("/secteur/{idSecteur}")
    public List<Quartier> findByidSecteur(@ PathVariable long idSecteur) {
        return quartierService.findByidSecteur(idSecteur);
    }
    //  already teste
   @GetMapping("/libelleSecteur/{libelleSecteur}")
    public List<Quartier> findByLibelleSecteur(@PathVariable String libelleSecteur) {
        return quartierService.findByLibelleSecteur(libelleSecteur);
    }
    /// ou existe une rue 
    // already exist
    @GetMapping("/RueExist/{id}")
    public Quartier WhereStreetExist(@PathVariable long id) {
        return quartierService.WhereStreetExist(id);
    }
    /// 
  @GetMapping("/id/{id}")
    public Quartier findByid(@PathVariable long id) {
        return quartierService.findByid(id);
    }
   @GetMapping("/exist/{id}")
    public int exitsts( @PathVariable long id) {
        return quartierService.exitsts(id);
    }
    
 
    
}
