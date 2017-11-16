package by.nc.school.dev.entities;

public class Dean extends User {

    public Dean(int id, String fullName, int role) {
        super(id, fullName, role);
    }

    @Override
    public String toString() {
        return "Dean{" +
                "fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }
}
