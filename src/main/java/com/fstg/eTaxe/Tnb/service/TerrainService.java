/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface TerrainService {

    // juste les signateur des methode ( tout les methode //) 
    public void save(Terrain terrain); // enregistre les terrain cree dans la base de donnees

    public List<Terrain> findAll();

    public Terrain findByReferance(String referance);
//    public Terrain findByid(Long id);

    public void deletTerrain(long id);

    public List<Terrain> findByCategorie(Categorie categorie);

    public List<Terrain> findByPropreitaire(Proprietaire proprietaire);

    public List<Terrain> findBySurface(BigDecimal surface);

    //Ali
    public Terrain findById(Long id);

    public List<Terrain> terrainsNonPayeeByProprietaire(Proprietaire proprietaire);

    public Boolean isPayee(String referance, int annee);

    public List<Integer> findAnneesTerrainsNonPayee(String referance);

    public BigDecimal calculeMontantRetard(Long id, int annee);
    
    public BigDecimal calculeMontantAnnuelle(Long id, int annee);
    
    public BigDecimal calculeMontantTotal(Long id, int annee);
    
    public Boolean isPropretaireHaveTerrain(Proprietaire proprietaire, Terrain terrain);

}
