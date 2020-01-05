package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class TauxTaxe implements Serializable { // paiement par categorie

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // chaque categorie  a une montant taxe  precise
    
    @OneToOne
    private Categorie categorie; 
    private BigDecimal montantTaxe;

    // date debut paiement 
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    // date fin paiement 
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TauxTaxe() {
    }

    public TauxTaxe(Categorie categorie, BigDecimal montantTaxe, Date dateDebut, Date dateFin) {
        this.categorie = categorie;
        this.montantTaxe = montantTaxe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public BigDecimal getMontantTaxe() {
        return montantTaxe;
    }

    public void setMontantTaxe(BigDecimal montantTaxe) {
        this.montantTaxe = montantTaxe;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "TauxTaxe{" + "categorie=" + categorie + ", montantTaxe=" + montantTaxe + ", dateDebut=" + dateDebut + ", finpaiement=" + dateFin + '}';
    }

}
