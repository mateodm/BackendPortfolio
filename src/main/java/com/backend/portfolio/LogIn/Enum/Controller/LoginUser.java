/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.Controller;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Mateo De Mari
 */
public class LoginUser {
    @NotBlank /*** SI ESTA EN BLANCO ***/
    private String name;
    @NotBlank
    private String password;
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
    
    
}
