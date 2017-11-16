package by.nc.school.dev.entities.factories;

import by.nc.school.dev.entities.User;
import by.nc.school.dev.entities.Tutor;

public class TutorFactory extends AbstractUserFactory {

    public User createUser(int id, String fullName, int role, int groupNumber) {
        return new Tutor(id, fullName, groupNumber);
    }
}
