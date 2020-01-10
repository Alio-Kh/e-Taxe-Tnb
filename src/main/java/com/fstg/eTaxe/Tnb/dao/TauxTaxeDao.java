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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yassine
 */
@Repository
public interface TauxTaxeDao extends JpaRepository<TauxTaxe, Long> {

    public TauxTaxe findByCategorie(Categorie categorie);

    public TauxTaxe findByMontantTaxe(BigDecimal montantTaxe);

    public TauxTaxe findByDateDebut(Date dateDebut);

    public TauxTaxe findByDateFin(Date dateFin);
     
    @Query("select t from TauxTaxe t where t.categorie = ?1 and ?2 between t.dateDebut and t.dateFin")
    public TauxTaxe findByCategorieAndDateNow(Categorie categorie,Date dateNow);

    @Query("select t from TauxTaxe t where t.categorie = ?1 and ?2 between t.dateDebut and t.dateFin")
    public TauxTaxe findByCategorieAndDateTaxe(Categorie categorie,Date dateTaxe);
}
