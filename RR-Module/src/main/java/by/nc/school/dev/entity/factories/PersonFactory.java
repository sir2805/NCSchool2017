package by.nc.school.dev.entity.factories;

import by.nc.school.dev.Role;
import by.nc.school.dev.dao.entity.UserDaoEntity;
import by.nc.school.dev.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonFactory extends AbstractPersonFactory {

    public Person createPerson(Person person) {
        return userFactories.get(person.getRole()).createPerson(person);
    }

    private Map<Integer, AbstractPersonFactory> userFactories = new HashMap<>();

    public PersonFactory() {
        userFactories.put(Role.STUDENT, new StudentFactory());
        userFactories.put(Role.TUTOR, new TutorFactory());
        userFactories.put(Role.CURATOR, new CuratorFactory());
        userFactories.put(Role.DEAN, new DeanFactory());
    }
}
