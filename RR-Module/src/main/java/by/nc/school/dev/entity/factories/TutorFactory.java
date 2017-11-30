package by.nc.school.dev.entity.factories;

import by.nc.school.dev.dao.entity.UserDaoEntity;
import by.nc.school.dev.entity.Person;
import by.nc.school.dev.entity.Tutor;

public class TutorFactory extends AbstractPersonFactory {

    @Override
    public Person createPerson(Person person) {
        return new Tutor(person.getId(), person.getFullname(), person.getRole());
    }
}
