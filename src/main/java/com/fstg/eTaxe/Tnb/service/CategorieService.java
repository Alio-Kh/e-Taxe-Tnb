/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface CategorieService {
    // juste la signateur de la fonction 
    // intelligence  ou metier de l'Application
    // au sein de service en trouve dao
    // framezork springboot  EJB entreprise java bean 
    public void save(Categorie categorie);
    public Categorie findByLibelle(String libelle);
    public List<Categorie>  findAll();
    public void deleteCategorie(long id);
//    public Categorie findById(Long id);

    
}
