package by.nc.school.dev.entities.factories;

import by.nc.school.dev.entities.Curator;
import by.nc.school.dev.entities.User;

public class CuratorFactory extends AbstractUserFactory {

    public User createUser(int id, String fullName, int role, int groupNumber) {
        return new Curator(id, fullName, role, groupNumber);
    }
}
