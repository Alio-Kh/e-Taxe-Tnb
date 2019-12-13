/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.service.CategorieService;
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
@RequestMapping("/e-Taxe-Tnb/categorie")
public class CategorieRest {

    @Autowired
    public CategorieService categorieService;

    //    tested
    @PostMapping(value = "/")
    public void save(@RequestBody Categorie categorie) {
        categorieService.save(categorie);
    }

    //    tested
    @GetMapping("/libelle/{libelle}")
    public Categorie findByLibelle(@PathVariable String libelle) {
        return categorieService.findByLibelle(libelle);
    }

//    @GetMapping("/id/{id}")
//    public Categorie findById(@PathVariable Long id){
//        return categorieService.findById(id);
//    }
    //    tested
    @DeleteMapping(value = "/id/{id}")
    public void deleteCategorie(@PathVariable long id) {
        categorieService.deleteCategorie(id);
    }

    //   tested
    @GetMapping("/")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

}
