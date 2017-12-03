package by.nc.school.dev.service;

import by.nc.school.dev.entity.User;

public interface UserService {

    User getUserByUsername(String username);

    User login(String login, String password);

    void changeUsername(Long userId, String newUsername);

    void changePassword(Long userId, String newPassword);

    void addUser(User user);
}