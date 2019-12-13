/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 */
@Repository
public interface ProprietaireDao extends JpaRepository<Proprietaire, Long> {

    public Proprietaire findByNom(String nom);

    public Proprietaire findByPrenom(String prenom);

    public Proprietaire findByAdresse(String adresse);

    public Proprietaire findByEmail(String email);

}
