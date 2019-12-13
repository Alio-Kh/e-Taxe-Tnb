/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
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
@RequestMapping("/e-Taxe-Tnb/proprietaire")
public class ProprietaireRest {

    @Autowired // permet d'instensier un objet   // si il troveent beaucoup de class fille erreur 
    private ProprietaireService proprietaireService;

    // already tste
    @PostMapping(value = "/")
    public void save(@RequestBody Proprietaire proprietaire) {
        proprietaireService.save(proprietaire);
    }

    // tested
    @GetMapping(value = "/nom/{nom}")
    public Proprietaire findByNom(@PathVariable String nom) {
        return proprietaireService.findByNom(nom);
    }

    // tested
    @GetMapping(value = "/prenom/{prenom}")
    public Proprietaire findByPrenom(@PathVariable String prenom) {
        return proprietaireService.findByPrenom(prenom);
    }

    // tested
    @GetMapping(value = "/adresse/{adresse}")
    public Proprietaire findByAdresse(@PathVariable String adresse) {
        return proprietaireService.findByAdresse(adresse);
    }

    // tested
    @GetMapping(value = "/email/{email}")
    public Proprietaire findByEmail(@PathVariable String email) {
        return proprietaireService.findByEmail(email);
    }

    // tested
    @GetMapping("/")
    public List<Proprietaire> findAll() {
        return proprietaireService.findAll();
    }

    // tested
    @DeleteMapping(value = "/id/{id}")
    public void deleteProprietaire(@PathVariable Long id) {
        proprietaireService.deleteProprietaire(id);
    }

}
