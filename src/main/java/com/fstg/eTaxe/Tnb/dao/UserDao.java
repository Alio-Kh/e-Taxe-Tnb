/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.dao;

import com.fstg.eTaxe.Tnb.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public User findByNom(String nom);

    public User findByPrenom(String prenom);

    public User findByEmail(String email);
    
    public User findByLogin(String login);
    
    public Boolean existsByLogin(String login);
    
    
}
