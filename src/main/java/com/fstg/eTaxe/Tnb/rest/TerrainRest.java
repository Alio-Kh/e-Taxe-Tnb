/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.math.BigDecimal;
import java.util.Date;
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

    @Autowired
    private ProprietaireService proprietaireService;

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
//    //  tested
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
    public Terrain findByReferance(@PathVariable String referance) { // dans l'input le meme variable (le meme nom de variable )
        return terrainservice.findByReferance(referance);

    }

    // tested
    @GetMapping("/categorie/")
    public List<Terrain> findByCategorie(@RequestBody Categorie categorie) {
        return terrainservice.findByCategorie(categorie);
    }

    // tested
    @GetMapping("/proprietaire/")
    public List<Terrain> findByPropreitaire(@RequestBody Proprietaire proprietaire) {
        return terrainservice.findByProprietaire(proprietaire);
    }

    // tested
    @GetMapping("/surface/{surface}")
    public List<Terrain> findBySurface(@PathVariable BigDecimal surface) {
        return terrainservice.findBySurface(surface);
    }

    //tested(Ali)
    @GetMapping("/referance1/{referance}")
    public List<Integer> findAnneesTerrainsNonPayee(@PathVariable String referance) {
        return terrainservice.findAnneesTerrainsNonPayee(referance);
    }

    //tested(Ali)
    @GetMapping("/referance/{referance}/annee/{annee}")
    public Boolean isPayee(@PathVariable String referance, @PathVariable int annee) {
        return terrainservice.isPayee(referance, annee);
    }

    //tested(Ali)
    @GetMapping("/proprietaire/id/{id}")
    public List<Terrain> terrainsNonPayeeByProprietaireId(@PathVariable long id) {
        return terrainservice.terrainsNonPayeeByProprietaire(proprietaireService.findById(id));
    }

    //tested(Ali)
    @GetMapping("/proprietaire/referance/{referance}")
    public List<Terrain> terrainsNonPayeeByProprietaireReferance(@PathVariable String referance) {
        return terrainservice.terrainsNonPayeeByProprietaire(proprietaireService.findByReferance(referance));
    }

    @GetMapping(value = "/id/{id}/annee/{annee}")
    public BigDecimal calculeMontantAnnuelle(@PathVariable Long id /*id terrain*/, @PathVariable int annee) {
        return terrainservice.calculeMontantAnnuelle(id, annee);
    }
//     @GetMapping(value = "/id/{id}/annee/{annee}")
//      public BigDecimal calculeMontantRetard(@PathVariable Long id /*id terrain*/, @PathVariable int annee){
//         return terrainservice.calculeMontantRetard(id, annee);
//     }
//     @GetMapping(value = "/id/{id}/annee/{annee}")
//      public BigDecimal calculeMontantTotal(@PathVariable Long id /*id terrain*/, @PathVariable int annee){
//         return terrainservice.calculeMontantTotal(id, annee);
//     }

    @GetMapping(value = "/proprietaire/referance/{referanceProprietaire}/terrain/referance/{referanceTerrain}")
    public Boolean isPropretaireHaveTerrain(@PathVariable String referanceProprietaire, @PathVariable String referanceTerrain) {
        return terrainservice.isPropretaireHaveTerrain(proprietaireService.findByReferance(referanceProprietaire), terrainservice.findByReferance(referanceTerrain));
    }
    // already tested (yassine)

    @GetMapping("/n/{n}")
    public List<Terrain> findTerrainNotifier(@PathVariable int n) {
        return terrainservice.findTerrainNotifier(n);
    }

    //aalready test (yassine)
    @GetMapping("/n/{n}/annee/{annee}")
    public List<Terrain> findByNumeroNotificationAndAnneNotification(@PathVariable int n, @PathVariable int annee) {
        return terrainservice.findByNumeroNotificationAndAnneNotification(n, annee);
    }

    //  already test yassin
    @PutMapping("/id/{id}")
    public void updateTerrain(@PathVariable long id) {
        terrainservice.updateTerrain(id);
    }

    //  already testyassine
    @GetMapping("/date/{dateNow}")
    public List<Terrain> findTerrainNonPayer(@PathVariable int dateNow) {
        return terrainservice.findTerrainNonPayer(dateNow);
    }

     @GetMapping("/save_Annees_Terrains_NonPayee")
    public void CreatePdfAnneesTerrainsNonPayee() {
         terrainservice.CreatePdfAnneesTerrainsNonPayee();
    }

}
