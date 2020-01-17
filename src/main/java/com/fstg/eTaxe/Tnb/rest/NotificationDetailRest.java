/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.NotificationDetail;
import com.fstg.eTaxe.Tnb.service.NotificationDetailService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yassine
 */
@RestController
@RequestMapping("/e-Taxe-Tnb/NotifiationDetail")
public class NotificationDetailRest {
    @Autowired
    private NotificationDetailService notificationDetailService;

    public List<NotificationDetail> findByMontant(BigDecimal montant) {
        return notificationDetailService.findByMontant(montant);
    }

    public List<NotificationDetail> findBymontantRetard(BigDecimal montantRetard) {
        return notificationDetailService.findBymontantRetard(montantRetard);
    }

//    public List<NotificationDetail> findByMontantTotal(BigDecimal MontantTotal) {
//        return notificationDetailService.findByMontantTotal(MontantTotal);
//    }

    public List<NotificationDetail> findBymessage(String message) {
        return notificationDetailService.findBymessage(message);
    }

    public List<NotificationDetail> findByannee(int annee) {
        return notificationDetailService.findByannee(annee);
    }

    public void save(NotificationDetail notificationDetail) {
        notificationDetailService.save(notificationDetail);
    }
    @PostMapping("/")
    public void notifierDetaillProprietaire(@PathVariable int annee) {
        notificationDetailService.notifierDetaillProprietaire(annee);
    }
    
    
    
    
    
}
