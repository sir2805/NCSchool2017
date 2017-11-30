package by.nc.school.dev.entity.factories;

import by.nc.school.dev.entity.Person;
import by.nc.school.dev.entity.Student;
import by.nc.school.dev.dao.entity.UserDaoEntity;

public class StudentFactory extends AbstractPersonFactory {

    @Override
    public Person createPerson(Person person) {
        return new Student(person.getId(), person.getFullname(), person.getRole(), person.getGroupNumber());
    }
}
