
package com.backend.portfolio.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size ( min = 2, max = 20, message = "Tiene que contener más de 2 caracteres")
    private String nombre;
    @NotNull
    @Size ( min = 2, max = 20, message = "Tiene que contener más de 2 caracteres y un máximo de 20")
    private String apellido;
    @NotNull
    @Size ( min = 1, max = 150, message = "Tiene que contener más de 2 caracteres y un máximo de 150")
    private String img;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

