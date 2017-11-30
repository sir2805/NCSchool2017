package by.nc.school.dev.service;

import by.nc.school.dev.entity.Person;
import by.nc.school.dev.entity.factories.PersonFactory;

public class PersonService {

    public Person getPersonByUsername(String username) {
        return new PersonFactory().createPerson(null);
    }

    public Person getPersonById(Long id) {
        return new PersonFactory().createPerson(null);
    }
}
