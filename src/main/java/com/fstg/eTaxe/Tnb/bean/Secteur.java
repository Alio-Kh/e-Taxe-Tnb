package com.fstg.eTaxe.Tnb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Secteur implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    @OneToMany(mappedBy = "secteur")
    private List<Quartier> quartiers;

    @JsonIgnore
    public List<Quartier> getQuartiers() {
        return quartiers;
    }

    @JsonSetter
    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Secteur(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;

    }

    @Override
    public String toString() {
        return "Secteur{" + "id=" + id + ", libelle=" + libelle + '}';
    }

    public Secteur() {
    }

}
