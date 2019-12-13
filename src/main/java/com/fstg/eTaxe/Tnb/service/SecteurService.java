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

    public Secteur findByLibelle(String libelle);

    public List<Secteur> findAll();

    public void save(Secteur secteur);

    public void deleteSecteur(long id);
}
