/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Notification;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface NotificationService {

 
    public void save(Notification notification);

    public Notification findByLibelle(String libelle);

    public List<Notification> findAll();

    public void deleteNotification(long id);

    public void update(long id, Notification notification);

    public Notification findById(long id);
    
}
