package by.nc.school.dev.entities.factories;

import by.nc.school.dev.entities.User;

public abstract class AbstractUserFactory {

    public abstract User createUser(int id, String fullName, int role, int groupNumber);
}
