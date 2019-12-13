package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yassine
 */
@Entity
public class Terrain implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String referance;
  //  private Rue rue 
    @ManyToOne
    private Categorie categorie; // chaque terrain a une categorie 
    private BigDecimal surface = BigDecimal.ZERO;
    @ManyToOne
    private Proprietaire proprietaire;
    
    public Terrain(long id, String referance, Categorie categorie, BigDecimal surface, Proprietaire proprietaire) {
        this.id = id;
        this.referance = referance;
        this.categorie = categorie;
        this.surface = surface;
        this.proprietaire = proprietaire;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setSurface(BigDecimal surface) {
        this.surface = surface;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public long getId() {
        return id;
    }

    public String getReferance() {
        return referance;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public Terrain() {
    }

    
    
}
