package by.nc.school.dev;

import by.nc.school.dev.entities.User;
import by.nc.school.dev.services.ServiceFactory;

public class LoginController {

    public User login(String username, String password) {
        return new ServiceFactory().getValidationService().validate(username, password);
    }
}
