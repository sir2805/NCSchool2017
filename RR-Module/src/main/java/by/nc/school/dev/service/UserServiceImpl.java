package by.nc.school.dev.service;

import by.nc.school.dev.repository.UserRepository;
import by.nc.school.dev.entity.*;
import org.springframework.beans.factory.annotation.Required;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    protected PersonService personService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User login(String login, String password) {
        User user = userRepository.findUserByUsername(login);
        if (user == null && "admin".equals(login)) {
            Admin admin = new Admin("admin");
            user = new User("admin", "admin", admin);
            addUser(user);
        }
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUserByFullname(String fullname) {
        return userRepository.findUserByPersonFullname(fullname);
    }

    @Override
    public void changeUsername(Long userId, String newUsername) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setUsername(newUsername);
        userRepository.save(oldUser);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setPassword(newPassword);
        userRepository.save(oldUser);
    }

    @Override
    public void addUser(String username, String password, Person person) {
        addUser(new User(username, password, person));
    }

    @Override
    public void addUser(String username, String password, String fullname, String role, Group group) {
        Person person = personService.createPerson(fullname, role, group);
        addUser(new User(username, password, person));
    }

    @Override
    public User createUser(String username, String password, String fullname, String role, Group group) {
        Person person = personService.createPerson(fullname, role, group);
        return new User(username, password, person);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
