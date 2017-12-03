package by.nc.school.dev.web;

public interface Pages {

    interface VIEWS {
        String PATH_ABSOLUTE = "/";
        interface LOGIN {
            String PATH = "/login";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "login";
        }
        interface HOME {
            String PATH = "/home";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "home";
        }
        interface ADD_USER {
            String PATH = "/add-user";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "add-user";
        }
    }

    interface USER {
        String PATH_ABSOLUTE = "/user";
        interface LOGIN {
            String PATH = "/login";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
        interface LOGOUT {
            String PATH = "/logout";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
        interface NEW_USER {
            String PATH = "/newUser";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
    }


}
