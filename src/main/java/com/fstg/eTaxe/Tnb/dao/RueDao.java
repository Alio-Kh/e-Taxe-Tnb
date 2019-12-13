/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fstg.eTaxe.Tnb.bean.Rue;
import java.util.List;

/**
 *
 * @author yassine
 */
@Repository
public interface RueDao extends JpaRepository<Rue, Long> {

    public Rue findByLibelle(String libelle);

//    public List<Rue> findByQuartier(Quartier quartier);

}
