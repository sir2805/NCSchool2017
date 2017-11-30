package by.nc.school.dev.entity;

import javax.persistence.Entity;

@Entity
public class Tutor extends Person {

    public Tutor(Long id, String fullName, int role) {
        super(id, fullName, role);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
