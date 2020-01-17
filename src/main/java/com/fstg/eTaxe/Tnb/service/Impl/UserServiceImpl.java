/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.Impl;

import com.fstg.eTaxe.Tnb.bean.User;
import com.fstg.eTaxe.Tnb.dao.UserDao;
import com.fstg.eTaxe.Tnb.service.UserService;
import com.fstg.eTaxe.Tnb.service.util.AscUtil;
import com.fstg.eTaxe.Tnb.service.util.HashUtil;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    final String secretKey = "ssshhhhhhhhhhh!!!!";

    @Override
    public String save(User user) {
        if (userDao.existsByLogin(user.getLogin())) {
            return user.getLogin() + " exist in data base";
        } else {
            String password = user.getPassword();
            try {
                //            user.setPassword(HashUtil.encryptPassword(password));
//                user.setPassword(HashUtil.encrypt(password));
                user.setPassword(AscUtil.encrypt(password, secretKey));
            } catch (Exception ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            userDao.save(user);
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
    public String update(String login, User User) {
        if (userDao.existsByLogin(login)) {
            User User1 = userDao.findByLogin(login);
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
            return "Update failed! (le User " + login + " n'existe pas)";
        }
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
