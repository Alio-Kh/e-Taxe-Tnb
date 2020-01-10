/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Quartier;
import com.fstg.eTaxe.Tnb.bean.Rue;
import com.fstg.eTaxe.Tnb.dao.QuartierDao;
import com.fstg.eTaxe.Tnb.service.QuartierService;
import com.fstg.eTaxe.Tnb.service.RueService;
import com.fstg.eTaxe.Tnb.service.SecteurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service
public class QuartierServiceImpl implements QuartierService {

    @Autowired
    private QuartierDao quartierDao;
      @Autowired
      private SecteurService service; 
      @Autowired
      private RueService rueService;
    @Override
    public Quartier findByLibelle(String libelle) {
        return quartierDao.findByLibelle(libelle);
    }

//    @Override
//    public Quartier findByRue(Rue rue) {
//        return quartierDao.findByRue(rue);
//    }
//    @Override
//    public List<Quartier> findBySecteur(Secteur secteur) {
//        return quartierDao.findBySecteur(secteur);
//    }
    @Override
    public void save(Quartier quartier) {
       service.saveAndTestExisting(quartier.getSecteur());
         service.saveAndTestExisting(quartier.getSecteur());
        getQuartierDao().save(quartier);
       
    }

    @Override
    public void deleteQuartier(long id) {
        getQuartierDao().deleteById(id);
    }

    @Override
    public List<Quartier> findAll() {
        return getQuartierDao().findAll();
    }

    /**
     * @return the quartierDao
     */
    public QuartierDao getQuartierDao() {
        return quartierDao;
    }

    /**
     * @param quartierDao the quartierDao to set
     */
    public void setQuartierDao(QuartierDao quartierDao) {
        this.quartierDao = quartierDao;
    }

    @Override
    public int exitsts(long id) {
        if (quartierDao.existsById(id)) {
            return 1;
        } else {
            return 0;
        }
    }

  

//    @Override
//    public List<Quartier> findbyidSecteur(long id) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        List <Quartier> quartiers;
//        
//    }

//    @Override
//    public List<Quartier> findbyidLibelle(String libelle) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
 
    @Override
    public List<Quartier> findSecteur() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return  quartierDao.findSecteur();
    }

   

    @Override
    public List<Quartier> findByidSecteur(long idSecteur) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return quartierDao.findByidSecteur(idSecteur);
    }

    @Override
    public List<Quartier> findByLibelleSecteur(String libelleSecteur) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return quartierDao.findByLibelleSecteur(libelleSecteur);
    }

    @Override
    public Quartier WhereStreetExist(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Rue rue =rueService.findByid(id);
        if (rue==null){
            return null;
        }else{
            return rue.getQuartier();
        }
            
    }

    @Override
    public Quartier findByid(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return quartierDao.findByid(id);
    }
    
    

   

}
