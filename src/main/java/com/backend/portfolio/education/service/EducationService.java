/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.education.service;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;
import com.backend.portfolio.education.entity.Education;
import com.backend.portfolio.education.repository.EducationRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
/**
 *
 * @author Mateo De Mari
 */
public class EducationService {
    /***Llamada repository*/
    @Autowired EducationRepository EducationRepo;
    public List<Education> list() { return EducationRepo.findAll();}
    /***FINDS */
    public Optional<Education> getByName(String name) { return EducationRepo.findByName(name);}
    public Optional<Education> getOne(int id) { return EducationRepo.findById(id); }
    /***EXISTS***/
    public boolean existsById(int id) {
        return EducationRepo.existsById(id);
    }
    /***DELETE***/
    public void delete(int id) { EducationRepo.deleteById(id);}
        /* SAVE */
    public void save(Education education) { EducationRepo.save(education);}
}
