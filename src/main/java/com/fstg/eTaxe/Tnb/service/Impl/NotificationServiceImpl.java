/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Notification;
import com.fstg.eTaxe.Tnb.dao.NotificationDao;
import com.fstg.eTaxe.Tnb.service.NotificationService;
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

}
