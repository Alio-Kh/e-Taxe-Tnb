package com.fstg.eTaxe.Tnb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
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
public class Rue implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    
    @ManyToOne
    private Quartier quartier;
    
    @OneToMany(mappedBy = "rue")
    private List<Terrain> terrains;

    @JsonIgnore
    public List<Terrain> getTerrains() {
        return terrains;
    }

    @JsonSetter
    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
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

    public Rue(long id, String libelle, Quartier quartier) {
        this.id = id;
        this.libelle = libelle;
        this.quartier = quartier;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    @Override
    public String toString() {
        return "Rue{" + "id=" + id + ", libelle=" + libelle + ", quartier=" + quartier + '}';
    }

    public Rue() {
    }

}
