
package com.backend.portfolio.LogIn.Enum.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Mateo De Mari
 */
@Entity
public class Rol{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
        private RolName rolName;
    /*** CONSTRUCTOR, GETTERS AND SETTERS ***/
    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolName = rolName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolNombre(RolName rolName) {
        this.rolName = rolName;
    }
    
    }
 
