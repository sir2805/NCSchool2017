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
        interface ADD_GROUP {
            String PATH = "/add-group";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "add-group";
        }
        interface ADD_SUBJECT {
            String PATH = "/add-subject";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "add-subject";
        }
        interface GROUP {
            String PATH = "/group";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "group";
        }
    }

    interface GROUP {
        String PATH_ABSOLUTE = "/group";
        interface INIT_GROUP {
            String PATH = "/init-group";
            String PATH_ABSOLUTE = GROUP.PATH_ABSOLUTE + PATH;
        }
        interface ADD_GROUP_MEMBER {
            String PATH = "/add-group-member";
            String PATH_ABSOLUTE = GROUP.PATH_ABSOLUTE + PATH;
        }
        interface ADD_GROUP {
            String PATH = "/add-group";
            String PATH_ABSOLUTE = GROUP.PATH_ABSOLUTE + PATH;
        }
    }

    interface SUBJECT {
        String PATH_ABSOLUTE = "/subject";
        interface ADD_SUBJECT {
            interface ADD {
                String PATH = "/add-subject";
                String PATH_ABSOLUTE = SUBJECT.PATH_ABSOLUTE + PATH;
            }
            interface FINISH {
                String PATH = "/finish";
                String PATH_ABSOLUTE = SUBJECT.PATH_ABSOLUTE + PATH;
            }
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
            String PATH = "/new-user";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
    }


}
