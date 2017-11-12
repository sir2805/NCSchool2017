package by.nc.school.dev.services;

import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.dao.UserDao;
import by.nc.school.dev.dao.entities.UserDaoEntity;
import by.nc.school.dev.enitities.*;


public class UserService {

    public User getUser(UserDaoEntity userDaoEntity) {

        return new UserBuilder().build(userDaoEntity);
    }

    public User getUserByFullName(String fullName) {

        UserDaoEntity userDaoEntity = new DaoFactory().getUserDao().getUserByFullName(fullName);
        return new UserBuilder().build(userDaoEntity);
    }

    public void changeUsername(User user, String newUsername) {
        UserDao userDao = new DaoFactory().getUserDao();
        UserDaoEntity entity = userDao.getUserByUserName(user.getLogin());
        entity.setUsername(newUsername);
        userDao.update(entity);
        user.setLogin(newUsername);
    }

    public void changePassword(User user, String newPassword) {
        UserDao userDao = new DaoFactory().getUserDao();
        UserDaoEntity entity = userDao.getUserByUserName(user.getLogin());
        entity.setPassword(newPassword);
        userDao.update(entity);
    }
}