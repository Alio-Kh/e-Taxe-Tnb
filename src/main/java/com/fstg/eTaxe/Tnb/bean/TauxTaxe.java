package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
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
    private Long id;
    // chaque categorie  a une montant taxe  precise
    @OneToOne
    private Categorie categorie;
    // private Terrain terrain;
    // private  Bigdicemal 
    private BigDecimal montantTaxe;

    @Temporal(TemporalType.DATE)
    private Date debutPaiement;

    @Temporal(TemporalType.DATE)
    private Date finPaiement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TauxTaxe() {
    }

    public TauxTaxe(Categorie categorie, BigDecimal montantTaxe, Date debutPaiement, Date finpaiement) {
        this.categorie = categorie;
        this.montantTaxe = montantTaxe;
        this.debutPaiement = debutPaiement;
        this.finPaiement = finpaiement;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Date getDebutPaiement() {
        return debutPaiement;
    }

    public Date getFinPaiement() {
        return finPaiement;
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

    public void setDebutPaiement(Date debutPaiement) {
        this.debutPaiement = debutPaiement;
    }

    public void setFinPaiement(Date finpaiement) {
        this.finPaiement = finpaiement;
    }

    @Override
    public String toString() {
        return "TauxTaxe{" + "categorie=" + categorie + ", montantTaxe=" + montantTaxe + ", debutPaiement=" + debutPaiement + ", finpaiement=" + finPaiement + '}';
    }

}
