/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.education.controller;

import com.backend.portfolio.LogIn.Enum.Controller.Mensaje;
import com.backend.portfolio.education.Dto;
import com.backend.portfolio.education.entity.Education;
import com.backend.portfolio.education.service.EducationService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateo De Mari
 */
@RestController
@RequestMapping("/expeducation")
@CrossOrigin(origins ="https://fir-portfolio12001324.web.app")
public class educationController {
    /***LLAMO SERVICE***/
    @Autowired EducationService educationService;

    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    /*** CREATE ***/
    @PostMapping("/new")
    public ResponseEntity<?> create (@RequestBody Dto dto) {
        if(StringUtils.isBlank(dto.getName())) { 
            return new ResponseEntity(new Mensaje("Falta un campo por llenar"), HttpStatus.BAD_REQUEST);
        } else {
        Education education = new Education(dto.getName(), dto.getContenido());
        educationService.save(education);
        return new ResponseEntity(new Mensaje("CREADO"), HttpStatus.ACCEPTED);
        }
    }
    /*** UPDATE ***/
    @PutMapping("/update/{id}")     /*** SOLICITO DATO A TRAVES DEL URL ***/
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Dto dto) {
        if(educationService.existsById(id)) {
           Education education = educationService.getOne(id).get();
           education.setName(dto.getName());
           education.setContenido(dto.getContenido());
           educationService.save(education);
           return new ResponseEntity(new Mensaje("Cambios realizados con exito"), HttpStatus.ACCEPTED);
        } 
        else {
            return new ResponseEntity( new Mensaje("No se ha encontrado ningún dato con el mismo ID"), HttpStatus.NOT_FOUND);
        }
    }
    /***DELETE***/
    @DeleteMapping("/delete/{id}") /*** SOLICITO DATO A TRAVES DEL URL ***/
    public ResponseEntity<?> delete(@PathVariable("id")int id) {
       if(educationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Elimnated"), HttpStatus.OK);
        } else {
            educationService.delete(id);
            return new ResponseEntity(new Mensaje("No se ha encontrado ningún id que coincida"), HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if(educationService.existsById(id)) {
            Education education = educationService.getOne(id).get();
            return new ResponseEntity(education, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity( new Mensaje("No existe el id indicado"), HttpStatus.NOT_FOUND);
        }
}
}
