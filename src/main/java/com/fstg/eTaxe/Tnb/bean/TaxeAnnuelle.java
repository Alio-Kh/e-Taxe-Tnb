package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


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
public class TaxeAnnuelle implements Serializable {

    @Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    private TauxTaxe tautTaxe;

    @ManyToOne
    private Proprietaire proprietaire;

    @ManyToOne
    private Terrain terrain;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date paiement;
    private BigDecimal montant;
    private int annee;

    public TaxeAnnuelle(long id, TauxTaxe tauttaxe, Proprietaire proprietaire, Terrain terrain, Date paiement, BigDecimal montant, int annee) {
        this.id = id;
        this.tautTaxe = tauttaxe;
        // this.proprietaire = proprietaire;
        this.terrain = terrain;
        this.paiement = paiement;
        this.montant = montant;
        this.annee = annee;
    }

    public TaxeAnnuelle() {

    }

    public long getId() {
        return id;
    }

    public Date getPaiement() {
        return paiement;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public int getAnnee() {
        return annee;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTauttaxe(TauxTaxe tauttaxe) {
        this.tautTaxe = tauttaxe;
    }

//    public void setProprietaire(Proprietaire proprietaire) {
//        this.proprietaire = proprietaire;
//    }
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void setPaiement(Date paiement) {
        this.paiement = paiement;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public TauxTaxe getTautTaxe() {
        return tautTaxe;
    }

    public void setTautTaxe(TauxTaxe tautTaxe) {
        this.tautTaxe = tautTaxe;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return "TauxTaxeAnnuelle{" + "id=" + id + ", tauttaxe=" + tautTaxe + ", proprietaire="
                +// proprietaire + 
                ", terrain=" + terrain + ", paiement=" + paiement + ", montant=" + montant + ", annee=" + annee + '}';
    }

}
