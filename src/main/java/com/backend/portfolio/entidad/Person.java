
package com.backend.portfolio.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
/*** DECLARO QUE ES ENTIDAD ***/
@Entity
public class Person {
    /*** ID AUTOGENERABLE ***/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull /*** QUE NO SEA NULO Y QUE ESTABLECER MIN-MAX DE LETRAS ***/
    @Size ( min = 2, max = 20, message = "Tiene que contener más de 2 caracteres")
    private String nombre;
    @NotNull
    @Size ( min = 2, max = 20, message = "Tiene que contener más de 2 caracteres y un máximo de 20")
    private String apellido;
    @NotNull
    @Size ( min = 1, max = 150, message = "Tiene que contener más de 2 caracteres y un máximo de 150")
    private String img;
    @Size ( min = 1, max = 150, message = "Tiene que contener más de 2 caracteres y un máximo de 150")
    private String aboutMe;
    @Size ( min = 100, max = 550, message = "Tiene que contener más de 20 caracteres y un máximo de 550")
    
     /*** GETTERS AND SETTERS ***/

    public Long getId() {
        return id;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
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

