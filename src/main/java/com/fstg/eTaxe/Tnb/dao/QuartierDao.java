/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.bean.Rue;
import com.fstg.eTaxe.Tnb.bean.Secteur;
import java.util.List;

/**
 *
 * @author yassine
 */
@Repository
public interface QuartierDao extends JpaRepository<Quartier, Long> {

    public Quartier findByLibelle(String libelle);

    public Quartier findByRue(Rue rue);

//    public List<Quartier> findBySecteur(Secteur secteur);

}
