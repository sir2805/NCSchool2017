package by.nc.school.dev.service;

import by.nc.school.dev.entity.Curator;
import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Person;
import by.nc.school.dev.entity.Tutor;

public interface PersonService {

    Person createPerson(String fullname, String role, Group group);

    Person getPersonByfullname(String fullname);

    void removePerson(Person person);

    Curator changeTutorToCurator(Tutor tutor, Group group);

    void saveNewlyAddedCurator(Curator curator);

    void savePerson(Person person);
}
