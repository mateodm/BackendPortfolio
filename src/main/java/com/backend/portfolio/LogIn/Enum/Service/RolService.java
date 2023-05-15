/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.Service;

import com.backend.portfolio.LogIn.Enum.Entity.Rol;
import com.backend.portfolio.LogIn.Enum.Entity.RolName;
import com.backend.portfolio.LogIn.Enum.Security.InterfaceRol;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
/**
 *
 * @author Mateo De Mari
 */
public class RolService {
    @Autowired InterfaceRol interfaceRol;
    public Optional<Rol> getByRolName(RolName rolName) {
        return interfaceRol.findByRolName(rolName);
    }
}
