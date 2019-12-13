/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// microservice une petit  application avec ca propre base de donnee et serveur ...
/**
 *
 * @author yassine
 */
@RestController
@RequestMapping("/e-Taxe-Tnb/terrain")
public class TerrainRest {

    // pas de traitement 
    @Autowired // permet d'instensier un objet   // si il troveent beaucoup de class fille erreur 
    private TerrainService terrainservice;
    // already test

    @PostMapping(value = "/")// ajouter un terrain 
    public void save(@RequestBody Terrain terrain) {
        terrainservice.save(terrain);
    }
    // already test

    @GetMapping(value = "/")
    public List<Terrain> findAll() {
        return terrainservice.findAll();
    }
//    // already test
//    @GetMapping(value="/id/{id}") 
//    public Terrain findByid(@PathVariable Long id) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         return terrainservice.findByid(id);
//    }
    
    // tested
    @DeleteMapping(value = "/id/{id}")
    public void deleteTerain(@PathVariable long id) {
        terrainservice.deletTerrain(id);
    }
    
    // tested
    @GetMapping("/referance/{referance}")
    public List<Terrain> findByReferance(@PathVariable String referance) { // dans l'input le meme variable (le meme nom de variable )
        return terrainservice.findByReferance(referance);

    }

    @GetMapping("/categorie/")
    public List<Terrain> findByCategorie(@RequestBody Categorie categorie) {
        return terrainservice.findByCategorie(categorie);
    }

    @GetMapping("/proprietaire/")
    public List<Terrain> findByPropreitaire(@RequestBody Proprietaire proprietaire) {
        return terrainservice.findByPropreitaire(proprietaire);
    }

    @GetMapping("/surface/{surface}")
    public List<Terrain> findBySurface(@PathVariable BigDecimal surface) {
        return terrainservice.findBySurface(surface);
    }

}
