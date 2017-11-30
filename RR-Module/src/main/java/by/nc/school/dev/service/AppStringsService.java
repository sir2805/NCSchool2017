package by.nc.school.dev.service;

public interface AppStringsService {

    interface EXCEPTION {
        String KEY = "exception";
        interface SAVE_STORAGE {
            String KEY = EXCEPTION.KEY + ".save_storage";
        }
    }

    interface WEB {
        String KEY = "web";
        interface LOGIN {
            String KEY = WEB.KEY + ".login";
            interface TITLE {
                String KEY = LOGIN.KEY + ".title";
            }
            interface USER {
                String KEY = LOGIN.KEY + ".user";
            }
            interface PASSWORD {
                String KEY = LOGIN.KEY + ".password";
            }
            interface SUBMIT {
                String KEY = LOGIN.KEY + ".submit";
            }
        }
        interface LOGOUT {
            String KEY = WEB.KEY + ".logout";
            interface SUBMIT {
                String KEY = LOGOUT.KEY + ".submit";
            }
        }
        interface HOME {
            String KEY = WEB.KEY + ".home";
            interface TITLE {
                String KEY = HOME.KEY + ".title";
            }
            interface NEW_USER {
                String KEY = HOME.KEY + ".newuser";
                interface TITLE {
                    String KEY = NEW_USER.KEY + ".title";
                }
                interface SUBMIT {
                    String KEY = NEW_USER.KEY + ".submit";
                }
            }
        }
    }

    String getString(String key);

    String getString(String key, Object... substitution);

}
