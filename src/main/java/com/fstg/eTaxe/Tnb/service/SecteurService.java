/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Secteur;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface SecteurService {
    
    
    /// yassine

   public Secteur findByLibelle(String libelle);

    public List<Secteur> findAll();
      public Secteur findByid(long id);

   public int saveAndTestExisting(Secteur secteur);
   public void deleteByid(long id);

    public int deleteSecteur(long id);
    public Secteur WhereDistricExiste(long idQuartier);
     public int exitstsByid(long id);
     public int existByLibelle(String libelle);
     
}
