/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.NotificationDetail;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.NotificationDetailDao;
import com.fstg.eTaxe.Tnb.service.NotificationDetailService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class NotificationDetailServiceImpl  implements NotificationDetailService{
    @Autowired
    private NotificationDetailDao notificationDetailDao;
    @Autowired
    private TerrainService terrainService;

    @Override
    public List<NotificationDetail> findByMontant(BigDecimal montant) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return notificationDetailDao.findByMontant(montant);
    }

    @Override
    public List<NotificationDetail> findBymontantRetard(BigDecimal montantRetard) {
        return notificationDetailDao.findBymontantRetard(montantRetard);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotificationDetail> findByMontantTotal(BigDecimal MontantTotal) {
        return notificationDetailDao.findByMontantTotal(MontantTotal);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotificationDetail> findBymessage(String message) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return notificationDetailDao.findBymessage(message);
    }

    @Override
    public List<NotificationDetail> findByannee(int annee) {
        return notificationDetailDao.findByannee(annee);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(NotificationDetail notificationDetail) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        notificationDetailDao.save(notificationDetail);
    }

    /*@Override
    public List<NotificationDetail> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return detailDao.findAll();
    }
*/
    /*
     private BigDecimal montant;
    private BigDecimal montantRetard;
    private BigDecimal MontantTotal;
    private String message;
    
    private int annee;
    
    **/
    

    @Override
    public void notifierDetaillProprietaire(int annee) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       List<Terrain> terrains= terrainService.findAll();
       for(Terrain terrain:terrains){
           if(terrain.getDarierNotification().getNumeroNotification()==2 || terrain.getDarierNotification().getNumeroNotification()==3){
             BigDecimal montant,montantRetard,montanTotal;
               montant=terrainService.calculeMontantAnnuelle(terrain.getId(), annee);
               montantRetard=terrainService.calculeMontantRetard(terrain.getId(), annee);
               montanTotal=montantRetard.add(montant);
               terrain.getDarierNotification().getNotificationDetail().setMontant(montant);
               terrain.getDarierNotification().getNotificationDetail().setMontantRetard(montantRetard);
               terrain.getDarierNotification().getNotificationDetail().setMontantTotal(montanTotal);
              terrain.getDarierNotification().getNotificationDetail().setAnnee(annee);
              terrainService.updateTerrain(terrain.getId());
           }
       }
    }

    @Override
    public List<NotificationDetail> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
