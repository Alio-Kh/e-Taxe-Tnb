/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Rue;
import com.fstg.eTaxe.Tnb.service.RueService;
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
@RequestMapping("/e-Taxe-Tnb/rue")
public class RueRest {
    
    // already tested (yassine)
     @Autowired
    public RueService rueService;
    
     //tested
    @GetMapping(value="/libelle/{libelle}")
    public Rue findByLibelle(@PathVariable String libelle) {
        return rueService.findByLibelle(libelle);
    }
    
//    @GetMapping(value="/quartier/{quartier}")
//    public List<Rue> findByQuartier(@PathVariable Quartier quartier) {
//        return rueService.findByQuartier(quartier);
//    }
    
    //tested
    @GetMapping(value="/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }
    
    //tested
    @PostMapping(value="/")
    public void save(@RequestBody Rue rue) {
        rueService.save(rue);
    }
    
    //tested
    @DeleteMapping(value="/id/{id}")
    public void deleteRue(@PathVariable long id) {
        rueService.deleteRue(id);
    }

    public Rue findByid(long id) {
        return rueService.findByid(id);
    }
    // already tested
    @GetMapping("/idquartier/{idquartier}")
    public List<Rue> findByIdQuartier( @PathVariable long idquartier) {
        return rueService.findByIdQuartier(idquartier);
    }
    // already tested
   @GetMapping("/libelleQuartie/{libelleQuartie}")
    public List<Rue> findByLibelleQuartier( @PathVariable String libelleQuartie) {
        return rueService.findByLibelleQuartier(libelleQuartie);
    }
   //// already tested
    public Rue WhereTerrainExist(long idTerrain) {
        return rueService.WhereTerrainExist(idTerrain);
    }
    
}
