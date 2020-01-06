/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author alikhyatti
 */
@Entity
public class TauxTaxeRetard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal tauxTaxeRetard;

    public BigDecimal getTauxTaxeRetard() {
        return tauxTaxeRetard;
    }

    public void setTauxTaxeRetard(BigDecimal tauxTaxeRetard) {
        this.tauxTaxeRetard = tauxTaxeRetard;
    }

    private int nombreMois;

    @OneToOne
    private Categorie categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getNombreMois() {
        return nombreMois;
    }

    public void setNombreMois(int nombreMois) {
        this.nombreMois = nombreMois;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "TauxTaxeReratd{" + "id=" + id + ", nombreMois=" + nombreMois + ", categorie=" + categorie + '}';
    }

}
