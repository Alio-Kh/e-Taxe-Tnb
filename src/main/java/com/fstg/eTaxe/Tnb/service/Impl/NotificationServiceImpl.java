/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Notification;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.NotificationDao;
import com.fstg.eTaxe.Tnb.dao.TerrainDao;
import com.fstg.eTaxe.Tnb.service.NotificationService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import com.fstg.eTaxe.Tnb.service.util.DateUtil;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikhyatti
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    public NotificationDao notificationDao;
    @Autowired
    public TerrainService terrainService;
    @Autowired
    public TerrainDao terrainDao;
    DateUtil dateUtil;
    @Override
    public void save(Notification notification) {
        notificationDao.save(notification);
    }

    @Override
    public Notification findByLibelle(String libelle) {
        return notificationDao.findByLibelle(libelle);
    }

//    @Override
//    public Categorie findById(Long id) {
//        return categoriDao.findById(id);
//    }
    @Override
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }

    // not implemented yet
    @Override
    public void update(long id, Notification notification) {
        Notification existedNotification = findById(id);
        existedNotification.setLibelle(notification.getLibelle());
        notificationDao.save(existedNotification);
    }

    @Override
    public void deleteNotification(long id) {
        notificationDao.deleteById(id);
    }

    @Override
    public Notification findById(long id) {
        return notificationDao.findById(id).get();
    }
// yassine 
    @Override
    public int HowMuchNotifierProprietaire(Proprietaire proprietaire) {
        int cmp=0;
        List<Terrain> terrains=terrainService.findByPropreitaire(proprietaire);
           for(Terrain terrain :terrains){
               if(terrain.getDarierNotification()!=null){
                   cmp=1+cmp;
                   
               }
           }
           return cmp;
        
    }
// yassine
    @Override
    public void NotifierTerrain( int n) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       List<Terrain> terrains=terrainService.findTerrainNotifier(n-1);
       for(Terrain terrain1:terrains){
           terrain1.getDarierNotification().setNumeroNotification(n);
           terrainService.updateTerrain(terrain1.getId());
       }
       
    }

    @Override
    public void NotifierNow(int dateNow,int numeroNotification) {
        //int annee=dateUtil.formatToYearInteger(dateNow);
         List<Terrain> terrains=terrainService.findTerrainNonPayer(dateNow);
         
        
    }

    @Override
    public void NotifierUrgent(int annee) {
        
         List<Terrain> terrains=terrainService.findTerrainNonPayer(annee);
         for(Terrain terrain:terrains){
            int nombreAnneRetard=0;
            nombreAnneRetard=annee-terrain.getDerinierAnneePayee();
             if(nombreAnneRetard>3 && terrain.getDarierNotification().getNumeroNotification()>= 1 ){
                 
                 terrain.getDarierNotification().setNumeroNotification(3);
             }else if(nombreAnneRetard>=1  &&  terrain.getDarierNotification().getNumeroNotification()==2){
                  terrain.getDarierNotification().setNumeroNotification(3);
             }
                 
         } 
    }

    @Override
    public int NotifierTerrain(long id,int n) {
        Terrain terrain =terrainService.findyidAndNumeroNotification(id, n-1);
        if(terrain==null){
            return -1;
        }else {
                terrain.getDarierNotification().setNumeroNotification(n);
                return 1;
        }
    }
    
    

}
