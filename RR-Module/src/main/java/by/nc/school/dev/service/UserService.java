package by.nc.school.dev.service;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Person;
import by.nc.school.dev.entity.User;

public interface UserService {

    User getUserByUsername(String username);

    User getUserByFullname(String fullname);

    User login(String login, String password);

    void changeUsername(Long userId, String newUsername);

    void changePassword(Long userId, String newPassword);

    void saveUser(User user);

    void changePerson(User user, Person person);

    void saveUser(String username, String password, Person person);

    void saveUser(String username, String password, String fullname, String role, Group group);

    User createUser(String username, String password, String fullname, String role, Group group);
}