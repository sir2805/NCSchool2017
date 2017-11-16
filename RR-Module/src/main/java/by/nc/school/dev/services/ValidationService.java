package by.nc.school.dev.services;

import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.dao.UserDao;
import by.nc.school.dev.dao.entities.UserDaoEntity;
import by.nc.school.dev.entities.User;

public class ValidationService {

    public User validate(String username, String password) {
        DaoFactory factory = new DaoFactory();
        UserDao userDao = factory.getUserDao();
        UserDaoEntity entity = userDao.getUserByUserName(username);
        User currentUser = null;
        if (entity == null) {
            System.out.println("username doesn't exist");
        } else if (!entity.getPassword().equals(password)) {
            System.out.println("incorrect password");
        } else {
            currentUser = new ServiceFactory().getUserService().getUser(entity);
            System.out.println("validation successful. Welcome " + currentUser.getFullName());
            System.out.println(currentUser);
        }
        return currentUser;
    }
}
