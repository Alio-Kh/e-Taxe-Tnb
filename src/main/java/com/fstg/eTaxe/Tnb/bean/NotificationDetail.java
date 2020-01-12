/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author yassine
 */
@Entity
public class NotificationDetail implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private BigDecimal montant;
    private BigDecimal montantRetard;
    private BigDecimal MontantTotal;
    private String message;
    
    private int annee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getMontantRetard() {
        return montantRetard;
    }

    public void setMontantRetard(BigDecimal montantRetard) {
        this.montantRetard = montantRetard;
    }

    public BigDecimal getMontantTotal() {
        return MontantTotal;
    }

    public void setMontantTotal(BigDecimal MontantTotal) {
        this.MontantTotal = MontantTotal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public NotificationDetail() {
    }

    public NotificationDetail(long id, BigDecimal montant, BigDecimal montantRetard, BigDecimal MontantTotal, String message, int annee) {
        this.id = id;
        
        this.montant = montant;
        this.montantRetard = montantRetard;
        this.MontantTotal = MontantTotal;
        this.message = message;
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "NotificationDetail{" + "id=" + id + ", montant=" + montant + ", montantRetard=" + montantRetard + ", MontantTotal=" + MontantTotal + ", message=" + message + ", annee=" + annee + '}';
    }
  
    
    
    
}
