package com.backend.portfolio.repositorio;
import com.backend.portfolio.entidad.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Repositorio extends JpaRepository<Person, Long> {
    
}
