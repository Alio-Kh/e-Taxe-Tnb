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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author yassine
 */
@Repository
public interface RueDao extends JpaRepository<Rue, Long> {

   public Rue findByLibelle(String libelle);
    public Rue findByid(long id);
   

//    public List<Rue> findByQuartier(Quartier quartier);
    // already tested
    @Query(value="SELECT * FROM rue WHERE rue.quartier=:idquartier",nativeQuery = true)
    public List<Rue> findByIdQuartier(@Param("idquartier") long idquartier);
    
      //"SELECT * FROM quartier,secteur WHERE quartier.secteur=secteur.id and secteur.libelle=:libelleSecteur"
    @Query(value="SELECT id,libelle FROM rue,quartier   WHERE rue.quartier=quartier.id and quartier.libelle=:libelleQuartie",nativeQuery = true)
    public List<Rue> findByLibelleQuartier(@Param("libelleQuartie") String libelleQuartie);


//    public List<Rue> findByQuartier(Quartier quartier);

}
