/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.Service;

import com.backend.portfolio.LogIn.Enum.Entity.User;
import com.backend.portfolio.LogIn.Enum.Security.UserInterface;
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
public class UserService {
    @Autowired UserInterface userInterface;
    public Optional<User> getByNameUser(String name) {
        return userInterface.findByName(name);
    }
    public boolean existsByNameUser(String name) {
        return userInterface.existsByName(name);
    }
    public void save(User user) {
        userInterface.save(user);
    }
}
