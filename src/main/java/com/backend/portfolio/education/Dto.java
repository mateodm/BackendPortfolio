/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.education;

import jakarta.validation.constraints.NotBlank;
import java.util.logging.Logger;

/**
 *
 * @author Mateo De Mari
 */
public class Dto {
    /***QUE SU VALOR NO TENGA CARACTERES***/
    @NotBlank private String name;
    @NotBlank private String contenido;
    /***CONSTRUCTORS, GETTERS AND SETTERS***/
    
    public Dto() {
    }

    public Dto(String name, String contenido) {
        this.name = name;
        this.contenido = contenido;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
