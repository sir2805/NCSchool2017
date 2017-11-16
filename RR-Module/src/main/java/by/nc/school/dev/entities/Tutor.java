package by.nc.school.dev.entities;

public class Tutor extends User {

    public Tutor(int id, String fullName, int role) {
        super(id, fullName, role);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }
}
