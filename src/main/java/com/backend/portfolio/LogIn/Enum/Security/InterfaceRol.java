/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.Security;

import com.backend.portfolio.LogIn.Enum.Entity.Rol;
import com.backend.portfolio.LogIn.Enum.Entity.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 *
 * @author Mateo De Mari
 */
public interface InterfaceRol extends JpaRepository<Rol, Integer> {
   Optional<Rol> findByRolName(RolName rolName); 
}
