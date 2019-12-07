/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;



/**
 *
 * @author yassine
 */
public interface ProprietaireService {
     public void save(Proprietaire pr);
     public void findByid(Long id);
  
    
}
