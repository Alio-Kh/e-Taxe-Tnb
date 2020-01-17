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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public List<Terrain> findByProprietaire(Proprietaire proprietaire) {
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
        Proprietaire proprietaire1 = new Proprietaire();
        proprietaire1 = proprietaireService.findById(proprietaire.getId());
        List<Terrain> terrains = new ArrayList<>();
        Date date = new Date();
        Document document = PdfUtil.createPdf("terrainsNonPayeeByProprietaire" + proprietaire1.getReferance());
        PdfUtil.pdfOpen(document);
        PdfUtil.pdfTitle(document, "    Terrains Non Payées du Propriétaire ");
        PdfUtil.editPdf(document, "Referance proprietaire : " + proprietaire1.getReferance());
        PdfUtil.editPdf(document, "referance : Rue      : Quartier  : Secteur");
        for (Terrain terrain : findByProprietaire(proprietaire1)) {
            if (terrain.getDerinierAnneePayee() < DateUtil.formatToYearInteger(date) - 1) {
                terrains.add(terrain);
                PdfUtil.editPdf(document, terrain.getReferance() + "           :  " /*+ terrain.getRue() + " " + terrain.getRue().getQuartier() + "  :  " + terrain.getRue().getQuartier().getSecteur()*/);

            }
        }
        PdfUtil.pdfClose(document);
        return terrains;
    }

//  tested 
    @Override
    public Boolean isPayee(String referance, int annee) {
        Terrain terrain = terrainDao.findByReferance(referance);
        return terrain.getDerinierAnneePayee() >= annee;
    }

// tested(Ali)
    @Override
    public List<Integer> findAnneesTerrainsNonPayee(String referance) {
        List<Integer> annees = new ArrayList<>();
        Terrain terrain = terrainDao.findByReferance(referance);
        Date date = new Date();
        Document document = PdfUtil.createPdf("AnneesTerrain" + terrain.getReferance() + "NonPayee");
        PdfUtil.pdfOpen(document);
        PdfUtil.pdfTitle(document, "            Annees du Terrain " + terrain.getReferance() + " Non Payee");
        PdfUtil.editPdf(document, "referance :  Nom Prenom : Année : Montant ");
        for (int i = terrain.getDerinierAnneePayee() + 1; i < DateUtil.formatToYearInteger(date); i++) {
            annees.add(i);
            PdfUtil.editPdf(document, terrain.getProprietaire().getReferance() + "            :  " + terrain.getProprietaire().getNom() + " " + terrain.getProprietaire().getPrenom() + "      :   " + String.valueOf(i) + " :   " + calculeMontantTotal(terrain.getId(), i));
        }
        PdfUtil.pdfClose(document);
        return annees;
    }

    //tested(Ali)
    @Override
    public void CreatePdfAnneesTerrainsNonPayee() {
        List<Terrain> terrains = terrainDao.findAll();
        Date date = new Date();
        Document document = PdfUtil.createPdf("AnneesTerrainsNonPayee");
        PdfUtil.pdfOpen(document);
        PdfUtil.pdfTitle(document, "               Annees Terrains Non Payee");
        for (Terrain terrain : terrains) {
            PdfUtil.editPdf(document, "Referance terrain : " + terrain.getReferance());
            PdfUtil.editPdf(document, "     referance :  Nom Prenom : Année : Montant ");
            for (int j = terrain.getDerinierAnneePayee() + 1; j < DateUtil.formatToYearInteger(date); j++) {
                PdfUtil.editPdf(document, "     " + terrain.getProprietaire().getReferance() + "            :  " + terrain.getProprietaire().getNom() + " " + terrain.getProprietaire().getPrenom() + "  :     " + String.valueOf(j) + " :   " + calculeMontantTotal(terrain.getId(), j));
            }
        }
        PdfUtil.pdfClose(document);
    }

// tested
    @Override
    public BigDecimal calculeMontantRetard(Long id, int annee) {
        Terrain terrain = new Terrain();
        terrain = findById(id);
        BigDecimal montant = new BigDecimal(BigInteger.ZERO);
        BigDecimal divisor = new BigDecimal(BigInteger.TEN.multiply(BigInteger.TEN));
        Date dateNow = new Date();
        long nombreMois = DateUtil.periodMonth(dateNow, DateUtil.parseYearIntegerToDate(annee));
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
//        if (taxeAnnuelleService.findByAnneeAndTerrain(annee, terrain) == null) {
        TauxTaxe tauxTaxe = tauxTaxeService.findByCategorieAndDateTaxe(terrain.getCategorie(), DateUtil.parseYearIntegerToDate(annee));
        if (tauxTaxe != null) {
            montant = (terrain.getSurface()).multiply(tauxTaxe.getMontantTaxe());
            return montant;
        }

//        }
        return montant;
    }

// tested
    @Override
    public BigDecimal calculeMontantTotal(Long id, int annee) {
        BigDecimal montant = calculeMontantRetard(id, annee).add(calculeMontantAnnuelle(id, annee));
        return montant;
    }

/// yassine
    @Override
    public List<Terrain> findTerrainNotifier(int n) {
        List<Terrain> terrains = findAll();
        List<Terrain> terrains1 = new ArrayList<Terrain>();
        for (Terrain terrain : terrains) {
            if (terrain.getDarierNotification().getNumeroNotification() == n) {
                terrains1.add(terrain);
            }
        }
        return terrains1;

    }
/// yassine

    // already test Yassine
    @Override
    public List<Terrain> findByNumeroNotificationAndAnneNotification(int n, int annee) {
        List<Terrain> terrains = findTerrainNotifier(n);
        List<Terrain> terrains1 = new ArrayList<Terrain>();
        for (Terrain t : terrains) {
            if (t.getDarierNotification().getAnnee() == annee) {
                terrains1.add(t);
            }
        }
        return terrains1;
    }

// yassine
    @Override
    public void updateTerrain(long id) {
        Terrain terrain = findById(id);
        terrainDao.save(terrain);
    }

    //yassine
    @Override
    public List<Terrain> findTerrainNonPayer(int dateNow) {
        // DateUtil dateUtil=new DateUtil();
        List<Terrain> terrains1 = new ArrayList<Terrain>();
        //int anneeNow=dateUtil.formatToYearInteger(dateNow);
        List<Terrain> terrains = findAll();
        for (Terrain terrain : terrains) {
            if (terrain.getDerinierAnneePayee() < dateNow) {
                terrains1.add(terrain);
            }
        }
        return terrains1;

    }

    @Override
    public Boolean isPropretaireHaveTerrain(Proprietaire proprietaire, Terrain terrain) {
        return terrain.getProprietaire().equals(proprietaire);
    }

    @Override
    public Terrain findyidAndNumeroNotification(long id, int numeroNotification) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Terrain terrain = findById(id);
        if (terrain.getDarierNotification().getNumeroNotification() == numeroNotification) {
            return terrain;
        }
        return null;
    }

    public Terrain findByNotification() {
        return null;
    }

}
