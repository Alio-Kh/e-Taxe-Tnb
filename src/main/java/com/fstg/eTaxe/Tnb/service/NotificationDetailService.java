/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.NotificationDetail;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface NotificationDetailService {
    
    
    public List<NotificationDetail> findByMontant(BigDecimal montant);
    
    public List<NotificationDetail> findBymontantRetard(BigDecimal montantRetard);
    
//    public List<NotificationDetail> findByMontantTotal(BigDecimal MontantTotal);
    
    public List<NotificationDetail> findBymessage(String message);
    
    public List<NotificationDetail> findByannee(int annee);
    
    public void  save(NotificationDetail notificationDetail);
    
      public List<NotificationDetail> findAll(); 
    //public List<Terrain> findAll();
    public void notifierDetaillProprietaire(int annee);
    
}
