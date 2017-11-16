package by.nc.school.dev.dao;

import by.nc.school.dev.Role;
import by.nc.school.dev.dao.entities.UserDaoEntity;
import by.nc.school.dev.data.FakeUserGenerator;
import by.nc.school.dev.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao<User> {

    public UserDao() {
        this.entities = new FakeUserGenerator().deserialize();
    }

    public User getUserByUserName(String userName) {
        for (UserDaoEntity entity : entities) {
            if (userName.equals(entity.getUsername())) {
                return entity;
            }
        }
        return null;
    }

    public User getUserByFullName(String fullName) {
        for (UserDaoEntity entity : entities) {
            if (fullName.equals(entity.getFullName())) {
                return entity;
            }
        }
        return null;
    }

    public List<User> getTutors() {
        List<UserDaoEntity> result = new ArrayList<>();
        for (UserDaoEntity entity : entities) {
            if (entity.getStatus() == Role.TUTOR || entity.getStatus() == Role.CURATOR) {
                result.add(entity);
            }
        }
        return result;
    }

    public User create(User entity) {
        return null;
    }

    public void update(User entity) {
        UserDaoEntity oldEntity = get(entity.getId());
        entities.remove(oldEntity);
        entities.add(entity);
    }

    public void delete(User entity) {
        entities.remove(entity);
    }
}
