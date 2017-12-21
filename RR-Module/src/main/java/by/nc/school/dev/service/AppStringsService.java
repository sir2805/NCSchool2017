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
        interface GROUP {
            String KEY = WEB.KEY + ".group";
            interface TITLE {
                String KEY = GROUP.KEY + ".title";
            }
            interface TABLE {
                String KEY = GROUP.KEY + ".table";
                interface STUDENT {
                    String KEY = GROUP.TABLE.KEY + ".fullname";
                }
            }
        }
        interface ADD_SUBJECT {
            String KEY = WEB.KEY + ".addsubject";
            interface TITLE {
                String KEY = ADD_SUBJECT.KEY + ".title";
            }
            interface SUBJECT {
                String KEY = ADD_SUBJECT.KEY + ".subject";
                interface NAME {
                    String KEY = SUBJECT.KEY + ".name";
                }
                interface SUBMIT {
                    String KEY = ADD_SUBJECT.KEY + ".submit";
                }
            }
            interface FINISH {
                String KEY = ADD_SUBJECT.KEY + ".finish";
            }
        }
        interface ADD_USER {
            String KEY = WEB.KEY + ".adduser";
            interface TITLE {
                String KEY = ADD_USER.KEY + ".title";
            }
            interface PERSON {
                String KEY = ADD_USER.KEY + ".person";
                interface FULLNAME {
                    String KEY = PERSON.KEY + ".fullname";
                }
                interface ROLE {
                    String KEY = PERSON.KEY + ".role";
                    interface STUDENT {
                        String KEY = ROLE.KEY + ".student";
                    }
                    interface TUTOR {
                        String KEY = ROLE.KEY + ".tutor";
                    }
                    interface CURATOR {
                        String KEY = ROLE.KEY + ".curator";
                    }
                    interface DEAN {
                        String KEY = ROLE.KEY + ".dean";
                    }
                    interface ADMIN {
                        String KEY = ROLE.KEY + ".admin";
                    }
                }
                interface GROUP {
                    String KEY = PERSON.KEY + ".group";
                }
            }
            interface SUBMIT {
                String KEY = ADD_USER.KEY + ".submit";
            }
        }
        interface ADD_GROUP {
            String KEY = WEB.KEY + ".addgroup";
            interface TITLE {
                String KEY = ADD_GROUP.KEY + ".title";
            }
            interface INIT {
                String KEY = ADD_GROUP.KEY + ".init";
                interface TITLE {
                    String KEY = INIT.KEY + ".title";
                }
                interface GROUPNUMBER {
                    String KEY = INIT.KEY + ".groupnumber";
                }
                interface SUBMIT {
                    String KEY = INIT.KEY + ".submit";
                }
            }
            interface CURATOR {
                String KEY = ADD_GROUP.KEY + ".curator";
//                interface USERNAME {
//                    String KEY = TABLE.KEY + ".username";
//                }
//                interface PASSWORD {
//                    String KEY = TABLE.KEY + ".password";
//                }
//                interface FULLNAME {
//                    String KEY = CURATOR.KEY + ".fullname";
//                }
            }
            interface TABLE {
                String KEY = ADD_GROUP.KEY + ".table";
                interface USERNAME {
                    String KEY = TABLE.KEY + ".username";
                }
                interface PASSWORD {
                    String KEY = TABLE.KEY + ".password";
                }
                interface FULLNAME {
                    String KEY = TABLE.KEY + ".fullname";
                }
            }
            interface ADD_STUDENT {
                String KEY = ADD_GROUP.KEY + ".addstudent";
                interface TITLE {
                    String KEY = ADD_STUDENT.KEY + ".title";
                }
//                interface USERNAME {
//                    String KEY = ADD_STUDENT.KEY + ".username";
//                }
//                interface PASSWORD {
//                    String KEY = ADD_STUDENT.KEY + ".password";
//                }
//                interface FULLNAME {
//                    String KEY = ADD_STUDENT.KEY + ".fullname";
//                }
                interface SUBMIT {
                    String KEY = ADD_STUDENT.KEY + ".submit";
                }
            }
            interface CREATE {
                String KEY = ADD_GROUP.KEY + ".create";
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
                interface FULLNAME {
                    String KEY = TABLE.KEY + ".fullname";
                }
                interface ROLE {
                    String KEY = TABLE.KEY + ".role";
                }
            }
        }
    }

    String getString(String key);

    String getString(String key, Object... substitution);

}
