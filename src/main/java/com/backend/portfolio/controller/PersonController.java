package com.backend.portfolio.controller;

import com.backend.portfolio.entidad.Person;
import com.backend.portfolio.service.ServicePerson;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "https://fir-portfolio12001324.web.app/")
public class PersonController {
    /*** INYECCION DE DEPENDENCIAS***/
    @Autowired ServicePerson serviceperson;
    /*** CREATE PERSON ***/
    @PostMapping("/create/person")
    public String createPerson(@RequestBody Person person) {
        serviceperson.savePerson(person);
        return "Una persona ha sido creada exitosamente";
    }
    /*** DELETE PERSON ***/
    @DeleteMapping("/delete/person/{id}")
    public String deletePerson(@PathVariable Long id) {
        serviceperson.deletePerson(id);
        return "La persona ha sido eliminada exitosamente";
    }
    /*** GET PERSON ***/
    @GetMapping("/get/persons")
    public List<Person> getPerson() {
        return serviceperson.getPerson();
    }
    @GetMapping("get/person")
    public Person findPerson() {
        return serviceperson.findPerson((long) 1);
    }
    /*** UPDATE PERSON ***/
    @PutMapping("/edit/person/{id}")
    public Person editPerson(
            @PathVariable Long id,
            @RequestParam("nombre") String newN,
            @RequestParam("apellido") String newA,
            @RequestParam("img") String newImg) {
        Person person = serviceperson.findPerson(id);
        person.setNombre(newN);
        person.setApellido(newA);
        person.setImg(newImg);
        return person;
    }
        @PutMapping("/edit/aboutme/{id}")
    public Person editPerson(
            @PathVariable Long id,
            @RequestParam("") String newAboutMe) {
        Person person = serviceperson.findPerson(id);
        person.setAboutMe(newAboutMe);
        return person;
    }
}