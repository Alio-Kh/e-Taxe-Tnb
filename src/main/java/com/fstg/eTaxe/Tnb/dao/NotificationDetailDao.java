/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Notification;
import com.fstg.eTaxe.Tnb.bean.NotificationDetail;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 */
@Repository
public interface NotificationDetailDao  extends JpaRepository<NotificationDetail,Long>{
    
     /*private BigDecimal montant;
    private BigDecimal montantRetard;
    private BigDecimal MontantTotal;
    private String message;
    
    private int annee;
*/
    List<NotificationDetail> findByMontant(BigDecimal montant);
    
    List<NotificationDetail> findBymontantRetard(BigDecimal montantRetard);
    
    List<NotificationDetail> findByMontantTotal(BigDecimal MontantTotal);
    
    List<NotificationDetail> findBymessage(String message);
    
    List<NotificationDetail> findByannee(int annee);
    
     
    
     public List<NotificationDetail> findAll(); 
    
    
}
