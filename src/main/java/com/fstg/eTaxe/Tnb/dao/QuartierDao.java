/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.bean.Rue;
import com.fstg.eTaxe.Tnb.bean.Secteur;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author yassine
 */
@Repository
public interface QuartierDao extends JpaRepository<Quartier, Long> {

    public Quartier findByLibelle(String libelle);
    public Quartier findByid(long id);

//    public Quartier findByRue(Rue rue);

//    public List<Quartier> findBySecteur(Secteur secteur);
    @Query(value="SELECT  * FROM quartier WHERE id=1",nativeQuery=true)
    public List<Quartier> findSecteur(); 
    @Query("SELECT Q FROM Quartier Q,Secteur S WHERE Q.secteur=S.id  and  Q.secteur=:idSecteur")
    public List<Quartier> findbyidSecteur(@Param("idSecteur") long idSecteur );
    
     @Query(value="SELECT *  FROM quartier  WHERE quartier.secteur=:idSecteur",nativeQuery=true)
     public List<Quartier> findByidSecteur(@Param("idSecteur")long idSecteur);
     
    @Query(value="SELECT * FROM quartier,secteur WHERE quartier.secteur=secteur.id and secteur.libelle=:libelleSecteur",nativeQuery = true)
    public  List<Quartier> findByLibelleSecteur(@Param("libelleSecteur") String libelleSecteur);
   

//    public Quartier findByRue(Rue rue);

//    public List<Quartier> findBySecteur(Secteur secteur);

}
