package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Quartier implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    @ManyToOne
    private Secteur secteur;
    @OneToMany(mappedBy = "quartier")
    private List<Rue> rues;

    public List<Rue> getRues() {
        return Collections.unmodifiableList(rues);
    }

    public void setRues(List<Rue> rues) {
        this.rues = rues;
    }

    public Quartier(long id, String libelle, Secteur secteur) {
        this.id = id;
        this.libelle = libelle;
        this.secteur = secteur;
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Quartier{" + "id=" + id + ", libelle=" + libelle + '}';
    }

    public Quartier() {
        
    }

}
