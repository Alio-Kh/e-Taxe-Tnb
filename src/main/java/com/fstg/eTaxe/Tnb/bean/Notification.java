/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.bean;

import java.io.Serializable;
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
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numeroNotification;
    private String libelle; 
    private int annee;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    @OneToOne
    private  NotificationDetail notificationDetail;
      
    public long getId() {
        return id;
    }

    public NotificationDetail getNotificationDetail() {
        return notificationDetail;
    }

    public void setNotificationDetail(NotificationDetail notificationDetail) {
        this.notificationDetail = notificationDetail;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroNotification() {
        return numeroNotification;
    }

    public void setNumeroNotification(int numeroNotification) {
        this.numeroNotification = numeroNotification;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
