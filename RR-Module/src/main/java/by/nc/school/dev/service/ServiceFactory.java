package by.nc.school.dev.service;

public class ServiceFactory {

    private static UserService userService;

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
