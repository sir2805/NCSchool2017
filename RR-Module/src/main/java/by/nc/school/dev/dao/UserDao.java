package by.nc.school.dev.dao;

import by.nc.school.dev.Role;
import by.nc.school.dev.data.FakeUserGenerator;
import by.nc.school.dev.enitities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao<User> {

    public UserDao() {
        this.entities = new FakeUserGenerator().deserialize();
    }

    public User getUserByUserName(String userName) {
        for (User entity : entities) {
            if (userName.equals(entity.getLogin())) {
                return entity;
            }
        }
        return null;
    }

    public User getUserByFullName(String fullName) {
        for (User entity : entities) {
            if (fullName.equals(entity.getFullName())) {
                return entity;
            }
        }
        return null;
    }

    public List<User> getTutors() {
        List<User> result = new ArrayList<>();
        for (User entity : entities) {
            if (entity.getUserRole() == Role.TUTOR || entity.getUserRole() == Role.CURATOR) {
                result.add(entity);
            }
        }
        return result;
    }

    public User create(User entity) {
        return null;
    }

    public void update(User entity) {
        User oldEntity = get(entity.getId());
        entities.remove(oldEntity);
        entities.add(entity);
    }

    public void delete(User entity) {
        entities.remove(entity);
    }
}
