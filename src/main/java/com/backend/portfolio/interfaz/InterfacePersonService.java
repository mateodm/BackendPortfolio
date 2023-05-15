package com.backend.portfolio.interfaz;
import com.backend.portfolio.entidad.Person;
import java.util.List;

/**
 *
 * @author Mateo De Mari
 */
public interface InterfacePersonService {
    public List<Person> getPerson();
    
    public void savePerson(Person person);
    
    public void deletePerson(Long id);
    
    public Person findPerson(Long id);
    
}
