package by.nc.school.dev.entity.factories;

import by.nc.school.dev.entity.Curator;
import by.nc.school.dev.entity.Person;

public class CuratorFactory extends AbstractPersonFactory {

    @Override
    public Person createPerson(Person person) {
        return new Curator(person.getId(), person.getFullname(), person.getRole(), person.getGroupNumber());
    }
}
