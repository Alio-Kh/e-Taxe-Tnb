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
import javax.persistence.TemporalType;


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
    private long id;

    @ManyToOne
    private TauxTaxe tauxTaxe;

    @ManyToOne
    private TauxTaxeRetard tauxTaxeReratd;
    
    @ManyToOne
    private Proprietaire proprietaire;

    private Boolean payee;

    public Boolean getPayee() {
        return payee;
    }

    public void setPayee(Boolean payee) {
        this.payee = payee;
    }
    
    @ManyToOne
    private Terrain terrain;

    public Terrain getTerrain() {
        return terrain;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaiement;
    private BigDecimal montant;
    private int annee;

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public TaxeAnnuelle(long id, TauxTaxe tauxTaxe, Proprietaire proprietaire, Terrain terrain, Date paiement, BigDecimal montant, int annee) {
        this.id = id;
        this.tauxTaxe = tauxTaxe;
        // this.proprietaire = proprietaire;
        this.terrain = terrain;
        this.montant = montant;
        this.annee = annee;
    }

    public TaxeAnnuelle() {

    }

    public long getId() {
        return id;
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


    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }


    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public TauxTaxe getTauxTaxe() {
        return tauxTaxe;
    }

    public void setTauxTaxe(TauxTaxe tauxTaxe) {
        this.tauxTaxe = tauxTaxe;
    }
    
    public TauxTaxeRetard getTauxTaxeReratd() {
        return tauxTaxeReratd;
    }

    public void setTauxTaxeReratd(TauxTaxeRetard tauxTaxeReratd) {
        this.tauxTaxeReratd = tauxTaxeReratd;
    }

    @Override
    public String toString() {
        return "TaxeAnnuelle{" + "id=" + id + ", tauxTaxe=" + tauxTaxe + ", tauxTaxeReratd=" + tauxTaxeReratd + ", proprietaire=" + proprietaire + ", payee=" + payee + ", terrain=" + terrain  + ", montant=" + montant + ", annee=" + annee + '}';
    }

}
