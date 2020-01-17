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
public class TaxeAnnuelle implements Comparable<TaxeAnnuelle>, Serializable  {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private TauxTaxe tauxTaxe;

    @ManyToOne
    private TauxTaxeRetard tauxTaxeRetard;
    
    @ManyToOne
    private Proprietaire proprietaire;

    
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
    
    public TauxTaxeRetard getTauxTaxeRetard() {
        return tauxTaxeRetard;
    }

    public void setTauxTaxeRetard(TauxTaxeRetard tauxTaxeRetard) {
        this.tauxTaxeRetard = tauxTaxeRetard;
    }

    @Override
    public String toString() {
        return "TaxeAnnuelle{" + "id=" + id + ", tauxTaxe=" + tauxTaxe + ", tauxTaxeRetard=" + tauxTaxeRetard + ", proprietaire=" + proprietaire +  ", terrain=" + terrain  + ", montant=" + montant + ", annee=" + annee + '}';
    }

    @Override
    public int compareTo(TaxeAnnuelle o) {
        return Integer.compare(this.annee, o.annee);
    }

}
