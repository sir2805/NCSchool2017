package by.nc.school.dev.entities.factories;

import by.nc.school.dev.entities.Dean;
import by.nc.school.dev.entities.User;

public class DeanFactory extends AbstractUserFactory {

    public User createUser(int id, String fullName, int role, int groupNumber) {
        return new Dean(id, fullName, role);
    }
}
