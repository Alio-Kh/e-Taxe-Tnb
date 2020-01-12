/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.bean.TauxTaxe;
import com.fstg.eTaxe.Tnb.bean.TauxTaxeRetard;
import com.fstg.eTaxe.Tnb.bean.Terrain;
import com.fstg.eTaxe.Tnb.dao.TerrainDao;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import com.fstg.eTaxe.Tnb.service.TauxTaxeRetardService;
import com.fstg.eTaxe.Tnb.service.TauxTaxeService;
import com.fstg.eTaxe.Tnb.service.TaxeAnnuelleService;
import com.fstg.eTaxe.Tnb.service.TerrainService;
import com.fstg.eTaxe.Tnb.service.util.DateUtil;
import com.fstg.eTaxe.Tnb.service.util.PdfUtil;
import com.itextpdf.text.Document;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Service
public class TerrainServiceImpl implements TerrainService {

    @Autowired
    private TerrainDao terrainDao;// pas de classe qui va implemente cette classe(Dao) c'est automatiquement jSpring data qui va fournir ca 
    // si il troveent beaucoup de class fille erreur 

    @Autowired
    private ProprietaireService proprietaireService;

    @Autowired
    private TaxeAnnuelleService taxeAnnuelleService;

    @Autowired
    private TauxTaxeService tauxTaxeService;

    @Autowired
    private TauxTaxeRetardService tauxTaxeRetardService;

    @Override
    public void save(Terrain terrain) {
        terrainDao.save(terrain);
    }

    @Override
    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    @Transactional
    @Override
    public void deletTerrain(long id) {
        terrainDao.deleteById(id);

    }

//    @Override
//    public Terrain findByid(Long id) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         return  terraindao.findByid(id);
//    }
    @Override
    public Terrain findByReferance(String referance) {
        return terrainDao.findByReferance(referance);
    }

    @Override
    public List<Terrain> findByCategorie(Categorie categorie) {
        return terrainDao.findByCategorie(categorie);

    }

    @Override
    public List<Terrain> findByPropreitaire(Proprietaire proprietaire) {
        return terrainDao.findByProprietaire(proprietaire);
    }

    @Override
    public List<Terrain> findBySurface(BigDecimal surface) {
        return terrainDao.findBySurface(surface);
    }

    @Override
    public Terrain findById(Long id) {
        return terrainDao.findById(id).get();
    }

    //  tested (Ali)
    @Override
    public List<Terrain> terrainsNonPayeeByProprietaire(Proprietaire proprietaire) {
        proprietaire = proprietaireService.findById(proprietaire.getId());
        List<Terrain> terrains = new ArrayList<>();
        Date date = new Date();
        for (Terrain terrain : terrainDao.findByProprietaire(proprietaire)) {
            if (terrain.getDerinierAnneePayee() < DateUtil.formatToYearInteger(date) - 1) {
                terrains.add(terrain);
            }
        }
        return terrains;
    }

//  tested 
    @Override
    public Boolean isPayee(String referance, int annee) {
        Terrain terrain = terrainDao.findByReferance(referance);
        return terrain.getDerinierAnneePayee() >= annee;
    }

// tested
    @Override
    public List<Integer> findAnneesTerrainsNonPayee(String referance) {
        List<Integer> annees = new ArrayList<>();
        Terrain terrain = terrainDao.findByReferance(referance);
        Date date = new Date();
        Document document = PdfUtil.createPdf();
        document.addTitle("findAnneesTerrainsNonPayee");
        PdfUtil.editPdf(document, "referance Terrain :  Nom proprietaire  Prenom proprietaire : Année\n");
        for (int i = terrain.getDerinierAnneePayee() + 1; i < DateUtil.formatToYearInteger(date); i++) {
            annees.add(i);
            PdfUtil.editPdf(document, terrain.getReferance() + " : " + terrain.getProprietaire().getNom() + " " + terrain.getProprietaire().getPrenom() + " : " + String.valueOf(i));
        }
        PdfUtil.pdfClose(document);
        return annees;
    }

// test
    @Override
    public BigDecimal calculeMontantRetard(Long id, int annee) {
        Terrain terrain = new Terrain();
        terrain = findById(id);
        BigDecimal montant = new BigDecimal(BigInteger.ZERO);
        BigDecimal divisor = new BigDecimal(BigInteger.TEN.multiply(BigInteger.TEN));
        Date dateNow = new Date();
        long nombreMois = DateUtil.periodMonth(DateUtil.parseYearIntegerToDate(annee), dateNow);
        TauxTaxeRetard tauxTaxeRetard = tauxTaxeRetardService.findByCategorie(terrain.getCategorie());
        if (tauxTaxeRetard.getNombreMois() < nombreMois) {
            montant = calculeMontantAnnuelle(id, annee).multiply(tauxTaxeRetard.getTauxTaxeRetard().divide(divisor)).multiply(BigDecimal.valueOf(nombreMois - 3));
            return montant;
        } else {
            return montant;
        }
    }

// tested
    @Override
    public BigDecimal calculeMontantAnnuelle(Long id /*id terrain*/, int annee) {
        BigDecimal montant = new BigDecimal(BigInteger.ZERO);
        Terrain terrain = new Terrain();
        terrain = findById(id);
        if (taxeAnnuelleService.findByAnneeAndTerrain(annee, terrain) == null) {
            TauxTaxe tauxTaxe = tauxTaxeService.findByCategorieAndDateTaxe(terrain.getCategorie(), DateUtil.parseYearIntegerToDate(annee));
            if (tauxTaxe != null) {
                montant = (terrain.getSurface()).multiply(tauxTaxe.getMontantTaxe());
                return BigDecimal.ZERO;
            }

        }
        return montant;
    }

// tested
    @Override
    public BigDecimal calculeMontantTotal(Long id, int annee) {
        BigDecimal montant = calculeMontantRetard(id, annee).add(calculeMontantAnnuelle(id, annee));
        return montant;
    }

    @Override
    public Boolean isPropretaireHaveTerrain(Proprietaire proprietaire, Terrain terrain) {
        return terrain.getProprietaire().equals(proprietaire);
    }

}
