/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/e-Taxe-Tnb/propritaire")
public class ProprietaireRest {
     @Autowired // permet d'instensier un objet   // si il troveent beaucoup de class fille erreur 
     private ProprietaireService  proService;
     // already tste
     @PostMapping(value="/")
     public void save(@RequestBody Proprietaire pr ){
        proService.save(pr);
     }
     @GetMapping(value="id/{id}")
     public void findByid(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        proService.findByid(id);
    }
    
    
}
