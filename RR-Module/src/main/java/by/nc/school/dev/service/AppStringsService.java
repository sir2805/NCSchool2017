package by.nc.school.dev.service;

public interface AppStringsService {

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
            interface TABLE {
                String KEY = HOME.KEY + ".table";
                interface USER {
                    String KEY = TABLE.KEY + ".user";
                }
                interface PASSWORD {
                    String KEY = TABLE.KEY + ".password";
                }
                interface COUNTRIES {
                    String KEY = TABLE.KEY + ".countries";
                }
            }
            interface NEW_USER {
                String KEY = HOME.KEY + ".newuser";
                interface TITLE {
                    String KEY = NEW_USER.KEY + ".title";
                }
                interface COUNTRIES {
                    String KEY = NEW_USER.KEY + ".countries";
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
