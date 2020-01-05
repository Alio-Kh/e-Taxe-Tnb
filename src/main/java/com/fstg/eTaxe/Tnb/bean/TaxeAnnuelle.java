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
    private long id;

    @ManyToOne
    private TauxTaxe tauxTaxe;

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
    private Date paiement;
    private BigDecimal montant;
    private int annee;

    public TaxeAnnuelle(long id, TauxTaxe tauxTaxe, Proprietaire proprietaire, Terrain terrain, Date paiement, BigDecimal montant, int annee) {
        this.id = id;
        this.tauxTaxe = tauxTaxe;
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

    @Override
    public String toString() {
        return "TauxTaxeAnnuelle{" + "id=" + id + ", tauttaxe=" + tauxTaxe + ", proprietaire="
                +// proprietaire + 
                ", terrain=" + terrain + ", paiement=" + paiement + ", montant=" + montant + ", annee=" + annee + '}';
    }

}
