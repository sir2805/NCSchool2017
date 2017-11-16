package by.nc.school.dev.entities.factories;

import by.nc.school.dev.Role;
import by.nc.school.dev.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserFactory extends AbstractUserFactory {

    public User createUser(int id, String fullName, int role, int groupNumber) {
        return userFactories.get(role).createUser(id, fullName, role, groupNumber);
    }

    private Map<Integer, AbstractUserFactory> userFactories = new HashMap<>();

    public UserFactory() {
        userFactories.put(Role.STUDENT, new StudentFactory());
        userFactories.put(Role.TUTOR, new TutorFactory());
        userFactories.put(Role.CURATOR, new CuratorFactory());
        userFactories.put(Role.DEAN, new DeanFactory());
    }
}
