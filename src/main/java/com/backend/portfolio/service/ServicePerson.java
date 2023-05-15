package com.backend.portfolio.service;

import com.backend.portfolio.entidad.Person;
import com.backend.portfolio.interfaz.InterfacePersonService;
import com.backend.portfolio.repositorio.Repositorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePerson implements InterfacePersonService {
    @Autowired
    Repositorio repositorio;

    @Override
    public List<Person> getPerson() {
        List<Person> person = repositorio.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        repositorio.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        repositorio.deleteById(id);
    }
    @Override
    public Person findPerson(Long id) {
        Person person = repositorio.findById(id).orElse(null);
        return person;
    }
}