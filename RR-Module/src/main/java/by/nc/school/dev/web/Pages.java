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
        interface SUBJECT {
            String PATH = "/subject";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "subject";
        }
        interface GROUP {
            String PATH = "/group";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "group";
        }
        interface ADD_WORKPLAN {
            String PATH = "/add-work-plan";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "add-work-plan";
        }
        interface JOURNAL {
            String PATH = "/journal";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "journal";
        }
        interface ANALYSIS {
            String PATH = "/analysis";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "analysis";
        }
    }

    interface GROUP {
        String PATH_ABSOLUTE = "/group";
//        interface INIT_GROUP {
//            String PATH = "/init-group";
//            String PATH_ABSOLUTE = GROUP.PATH_ABSOLUTE + PATH;
//        }
        interface ADD_STUDENT {
            String PATH = "/add-student";
            String PATH_ABSOLUTE = GROUP.PATH_ABSOLUTE + PATH;
        }
//        interface ADD_CURATOR {
//            String PATH = "/add-curator";
//            String PATH_ABSOLUTE = GROUP.PATH_ABSOLUTE + PATH;
//        }
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

    interface WORKPLAN {
        String PATH_ABSOLUTE = "/work-plan";
        interface ADD_WORKPLAN {
            String PATH = "/add-plan";
            String PATH_ABSOLUTE = WORKPLAN.PATH_ABSOLUTE + PATH;
        }
    }

    interface JOURNAL {
        String PATH_ABSOLUTE = "/journal";
        interface SELECT_GROUP {
            String PATH = "/select-group";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
        interface SELECT_SUBJECT {
            String PATH = "/select-subject";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
        interface PUT_MARK {
            String PATH = "/put-mark";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
        interface ADD_LESSON {
            String PATH = "/add-lesson";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
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
