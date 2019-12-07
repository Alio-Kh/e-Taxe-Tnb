/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 *///
//deduire de requete 
// communique avec nosql
@Repository// extend une classe qui s'appelle jpa repostory
public interface CategorieDao  extends   JpaRepository<Categorie, Long>{
    
     public Categorie findBylibelle(String libelle);

    
 //  findByRef( String ref); deletBy
     
    
    
    
}
