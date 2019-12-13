/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 */
@Repository
public interface TauxTaxeDao extends JpaRepository<TauxTaxe, Long> {

    public List<TauxTaxe> findByCategorie(Categorie categorie);

    public TauxTaxe findByMontantTaxe(BigDecimal montantTaxe);

    public TauxTaxe findByDateDebut(Date dateDebut);

    public TauxTaxe findByDateFin(Date dateFin);

}
