/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.User;
import com.fstg.eTaxe.Tnb.dao.UserDao;
import com.fstg.eTaxe.Tnb.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String save(User User) {
        if (userDao.existsByReferance(User.getReferance())) {
            return User.getReferance() + " exist in data base";
        } else {
            userDao.save(User);
            return "User saved";
        }
    }

    @Override
    public User findByNom(String nom) {
        return userDao.findByNom(nom);
    }

    @Override
    public User findByPrenom(String prenom) {
        return userDao.findByPrenom(prenom);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    //(Ali)
    @Override
    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public User findByReferance(String referance) {
        return userDao.findByReferance(referance);
    }

    @Override
    public String update(String referance, User User) {
        if (userDao.existsByReferance(referance)) {
            User User1 = userDao.findByReferance(referance);
            if (User.getEmail() != null) {
                User1.setEmail(User.getEmail());
            }
            if (User.getNom() != null) {
                User1.setNom(User.getNom());
            }
            if (User.getPrenom() != null) {
                User1.setPrenom(User.getPrenom());
            }
            userDao.save(User1);
            return "la mise à jour du User " + User1.getNom() + " " + User1.getPrenom() + " a réussi";
        } else {
            return "Update failed! (le User " + referance + " n'existe pas)";
        }
    }

    @Override
    public Boolean existsByReferance(String referance) {
        return userDao.existsByReferance(referance);
    }

    @Override
    public Boolean existsByLogin(String login) {
        return userDao.existsByLogin(login);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

}
