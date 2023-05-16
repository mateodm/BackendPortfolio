/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.education.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
/**
 *
 * @author Mateo De Mari
 */
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contenido;
    /*** CONSTRUCTORES ***/
    public Education() {
    }

    public Education(String name, String descripcion) {
        this.name = name;
        this.contenido = contenido;
    }
    /*** GETTERS AND SETTERS ***/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String descripcion) {
        this.contenido = contenido;
    }
    
}
