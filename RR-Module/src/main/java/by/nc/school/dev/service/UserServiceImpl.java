package by.nc.school.dev.service;

import by.nc.school.dev.dao.UserRepository;
import by.nc.school.dev.entity.User;
import org.springframework.beans.factory.annotation.Required;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User login(String login, String password) {
        User user = userRepository.findUserByUsername(login);
        if (user == null && "admin".equals(login)) {
            user = new User("admin", "admin", null);
            addUser(user);
        }
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public void changeUsername(Long userId, String newUsername) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setUsername(newUsername);
        userRepository.save(oldUser);
    }

    public void changePassword(Long userId, String newPassword) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setPassword(newPassword);
        userRepository.save(oldUser);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
