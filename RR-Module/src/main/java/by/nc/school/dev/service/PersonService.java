package by.nc.school.dev.service;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Person;

public interface PersonService {

    Person createPerson(String fullname, String role, Group group);

    Person getPersonByfullname(String fullname);

    void removePerson(Person person);
}
