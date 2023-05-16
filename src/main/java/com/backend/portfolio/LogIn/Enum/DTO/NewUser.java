/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.DTO;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mateo De Mari
 */
/*** CLASS CREAR USUARIO ***/
public class NewUser {
    private String name;
    private String password;
    private Set<String> roles = new HashSet<>();
    /*** GETTERS AND SETTERS ***/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
       
}
