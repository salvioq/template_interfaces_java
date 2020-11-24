package es.dam.gestion.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "persons")
public class PersonListWrapper {

    private List<Alumno> persons;

    @XmlElement(name = "person")
    public List<Alumno> getPersons() {
        return persons;
    }

    public void setPersons(List<Alumno> persons) {
        this.persons = persons;
    }
}