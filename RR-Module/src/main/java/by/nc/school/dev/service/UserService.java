package by.nc.school.dev.service;

import by.nc.school.dev.dao.UserRepository;
import by.nc.school.dev.dao.entity.UserDaoEntity;
import org.springframework.beans.factory.annotation.Required;


public class UserService {

    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDaoEntity getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public UserDaoEntity login(String username, String password) {
        UserDaoEntity userDaoEntity = userRepository.findUserByUsername(username);
        if (userDaoEntity.getPassword().equals(password)) {
            return userDaoEntity;
        } else {
            return null;
        }
    }

    public void changeUsername(Long userId, String newUsername) {
        UserDaoEntity oldUserDaoEntity = userRepository.findById(userId).get();
        oldUserDaoEntity.setUsername(newUsername);
        userRepository.save(oldUserDaoEntity);
    }

    public void changePassword(Long userId, String newPassword) {
        UserDaoEntity oldUserDaoEntity = userRepository.findById(userId).get();
        oldUserDaoEntity.setPassword(newPassword);
        userRepository.save(oldUserDaoEntity);
    }

    public void addUser(UserDaoEntity userDaoEntity) {
        userRepository.save(userDaoEntity);
    }
}