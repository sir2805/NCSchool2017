package by.nc.school.dev.enitities;

public class Dean extends User {

    public Dean(int id, int userRole, String login, String password, String fullName) {
        super(id, userRole, login, password, fullName);
    }

    @Override
    public String toString() {
        return "Dean{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", id=" + id +
                '}';
    }
}
