/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.service.CategorieService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    CategorieService categorieService;
    
    
    @PostMapping(value="/")
     public void save(@RequestBody Categorie categorie){
          categorieService.save(categorie);
     }
     
     
     
     
 
     @GetMapping("/libelle/( libelle)")
    public Categorie findBylibelle(String libelle){
        return categorieService.findBylibelle(libelle);
    }
    
    
    
    
    
    @GetMapping("all")
    public List<Categorie>  findAll(){
       return   categorieService.findAll();
    }

    
    
    
    
    
    
}
