package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
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
    private long id;
    private String libelle;
    @ManyToOne
    private Categorie categorie; // chaque terrain a une categorie 
    private BigDecimal surface = BigDecimal.ZERO;
    @ManyToOne
    private Proprietaire proprietaire;
    
    public Terrain(long id, String libelle, Categorie categorie, BigDecimal surface, Proprietaire proprietaire) {
        this.id = id;
        this.libelle = libelle;
        this.categorie = categorie;
        this.surface = surface;
        this.proprietaire = proprietaire;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public String getLibelle() {
        return libelle;
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
