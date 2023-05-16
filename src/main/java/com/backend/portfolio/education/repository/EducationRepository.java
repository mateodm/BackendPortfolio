/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.portfolio.education.repository;
import com.backend.portfolio.education.entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 *
 * @author Mateo De Mari
 */
public interface EducationRepository extends JpaRepository<Education, Integer>{
    public Optional<Education> findByName(String name);
            public boolean existsByName(String name);
    
}
