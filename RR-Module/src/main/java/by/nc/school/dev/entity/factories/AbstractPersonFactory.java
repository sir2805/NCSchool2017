package by.nc.school.dev.entity.factories;

import by.nc.school.dev.dao.entity.UserDaoEntity;
import by.nc.school.dev.entity.Person;

public abstract class AbstractPersonFactory {

    public abstract Person createPerson(Person person);
}
