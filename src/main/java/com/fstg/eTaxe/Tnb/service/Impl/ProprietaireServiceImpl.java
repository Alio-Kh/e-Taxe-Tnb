/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.Proprietaire;
import com.fstg.eTaxe.Tnb.dao.ProprietaireDao;
import com.fstg.eTaxe.Tnb.service.ProprietaireService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author yassine
 */
@Service
public class ProprietaireServiceImpl implements ProprietaireService {

    @Autowired
    private ProprietaireDao proprietaireDao;

    @Override
    public String save(Proprietaire proprietaire) {
        if (proprietaireDao.existsByReferance(proprietaire.getReferance())) {
            return proprietaire.getReferance() + " exist in data base";
        } else {
            proprietaireDao.save(proprietaire);
            return "proprietaire saved";
        }
    }

    @Override
    public Proprietaire findByNom(String nom) {
        return proprietaireDao.findByNom(nom);
    }

    @Override
    public Proprietaire findByPrenom(String prenom) {
        return proprietaireDao.findByPrenom(prenom);
    }

    @Override
    public Proprietaire findByAdresse(String adresse) {
        return proprietaireDao.findByAdresse(adresse);
    }

    @Override
    public Proprietaire findByEmail(String email) {
        return proprietaireDao.findByEmail(email);
    }

    @Override
    public List<Proprietaire> findAll() {
        return proprietaireDao.findAll();
    }

    @Transactional
    @Override
    public void deleteProprietaire(Long id) {
        proprietaireDao.deleteById(id);
    }

    //(Ali)
    @Override
    public Proprietaire findById(Long id) {
        return proprietaireDao.findById(id).get();
    }

    @Override
    public Proprietaire findByReferance(String referance) {
        return proprietaireDao.findByReferance(referance);
    }

    public Boolean exist(String referance) {
        return proprietaireDao.existsByReferance(referance);
    }

    @Override
    public String update(String referance, Proprietaire proprietaire) {
        if (proprietaireDao.existsByReferance(referance)) {
            Proprietaire proprietaire1 = proprietaireDao.findByReferance(referance);
            if (proprietaire.getAdresse() != null) {
                proprietaire1.setAdresse(proprietaire.getAdresse());
            }
            if (proprietaire.getEmail() != null) {
                proprietaire1.setEmail(proprietaire.getEmail());
            }
            if (proprietaire.getNom() != null) {
                proprietaire1.setNom(proprietaire.getNom());
            }
            if (proprietaire.getPrenom() != null) {
                proprietaire1.setPrenom(proprietaire.getPrenom());
            }
            if (proprietaire.getTele() != null) {
                proprietaire1.setTele(proprietaire.getTele());
            }
            proprietaireDao.save(proprietaire1);
            return "la mise à jour du proprietaire " + proprietaire1.getNom() + " " + proprietaire1.getPrenom() + " a réussi";
        } else {
            return "Update failed! (le prorietaire " + referance + " n'existe pas)";
        }
    }

}
