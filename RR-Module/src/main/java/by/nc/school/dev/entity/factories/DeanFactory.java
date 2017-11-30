package by.nc.school.dev.entity.factories;

import by.nc.school.dev.entity.Dean;
import by.nc.school.dev.entity.Person;
import by.nc.school.dev.dao.entity.UserDaoEntity;

public class DeanFactory extends AbstractPersonFactory {

    @Override
    public Person createPerson(Person person) {
        return new Dean(person.getId(), person.getFullname(), person.getRole());
    }
}
