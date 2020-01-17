/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service;

import com.fstg.eTaxe.Tnb.bean.User;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface UserService {

    public String save(User user);

    public User findByNom(String nom);

    public User findByPrenom(String prenom);

    public User findByEmail(String email);

    public List<User> findAll();

    public void deleteUser(Long id);

    public User findById(Long id);

    public String update(String referance, User user);

    public Boolean existsByLogin(String login);

    public User findByLogin(String login);

}
