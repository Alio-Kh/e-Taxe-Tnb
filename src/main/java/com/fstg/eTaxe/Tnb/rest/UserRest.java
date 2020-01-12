/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.rest;

import com.fstg.eTaxe.Tnb.bean.Categorie;
import com.fstg.eTaxe.Tnb.bean.User;
import com.fstg.eTaxe.Tnb.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yassine
 */
@RestController
@RequestMapping("/e-Taxe-Tnb/user")
public class UserRest {

    @Autowired // permet d'instensier un objet   // si il troveent beaucoup de class fille erreur 
    private UserService userService;

    // already testes
    @PostMapping(value = "/")
    public String save(@RequestBody User user) {
        return userService.save(user);
    }

    // tested
    @GetMapping(value = "/nom/{nom}")
    public User findByNom(@PathVariable String nom) {
        return userService.findByNom(nom);
    }

    // tested
    @GetMapping(value = "/prenom/{prenom}")
    public User findByPrenom(@PathVariable String prenom) {
        return userService.findByPrenom(prenom);
    }

    // tested
    @GetMapping(value = "/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    // tested
    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    // tested
    @DeleteMapping(value = "/id/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    //tested
    @GetMapping(value = "/referance/{referance}")
    public User findByReferance(@PathVariable String referance) {
        return userService.findByReferance(referance);
    }

    @PutMapping("/referance/{referance}")
    public String update(@PathVariable String referance, @RequestBody User user) {
        return userService.update(referance, user);
    }

    @GetMapping("/exist/referance/{referance}")
    public String exist(@PathVariable String referance) {
        if (userService.existsByReferance(referance)) {
            return "Le user " + userService.findByReferance(referance).getNom() + " " + userService.findByReferance(referance).getPrenom() + " existe";
        } else {
            return "Le user " + referance + " n'existe pas";
        }
    }
    
    @GetMapping("/exist/login/{login}")
    public String existsByLogin(@PathVariable String login) {
        if (userService.existsByLogin(login)) {
            return "Le user " + userService.findByLogin(login).getNom() + " " + userService.findByLogin(login).getPrenom() + " existe";
        } else {
            return "Le user " + login + " n'existe pas";
        }
    }

}
