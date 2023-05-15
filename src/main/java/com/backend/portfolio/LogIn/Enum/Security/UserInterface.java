/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.Security;

import com.backend.portfolio.LogIn.Enum.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 *
 * @author Mateo De Mari
 */
public interface UserInterface extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
    boolean existsByName(String name);
}
