package com.fstg.eTaxe.Tnb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ali
 */
@Entity
public class Terrain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String referance;

    @ManyToOne
    private Rue rue;
    
    @ManyToOne
    private Categorie categorie; // chaque terrain a une categorie 
    
    private BigDecimal surface = BigDecimal.ZERO;
    
    @ManyToOne
    private Proprietaire proprietaire;
    
    private int derinierAnneePayee;
   

    public int getDerinierAnneePayee() {
        return derinierAnneePayee;
    }

    public void setDerinierAnneePayee(int derinierAnneePayee) {
        this.derinierAnneePayee = derinierAnneePayee;
    }

    public Notification getDarierNotification() {
        return darierNotification;
    }

    public void setDarierNotification(Notification darierNotification) {
        this.darierNotification = darierNotification;
    }
    
    @OneToOne
    private Notification darierNotification;
    
    @OneToMany(mappedBy = "terrain")
    private List<TaxeAnnuelle> taxeAnnuelles;

    @Override
    public String toString() {
        return "Terrain{" + "id=" + id + ", referance=" + referance + ", rue=" + rue + ", categorie=" + categorie + ", surface=" + surface + ", proprietaire=" + proprietaire + ", derinierAnneePayee=" + derinierAnneePayee + ", darierNotification=" + darierNotification + ", taxeAnnuelles=" + taxeAnnuelles + '}';
    }

    @JsonIgnore
    public List<TaxeAnnuelle> getTaxeAnnuelles() {
        return taxeAnnuelles;
    }

    @JsonSetter
    public void setTaxeAnnuelles(List<TaxeAnnuelle> taxeAnnuelles) {
        this.taxeAnnuelles = taxeAnnuelles;
    }
    
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

    public Rue getRue() {
        return rue;
    }

    public void setRue(Rue rue) {
        this.rue = rue;
    }
    
}
