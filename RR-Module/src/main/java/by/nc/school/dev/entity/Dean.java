package by.nc.school.dev.entity;

import javax.persistence.Entity;

@Entity
public class Dean extends Person {

    public Dean(Long id, String fullName, int role) {
        super(id, fullName, role);
    }

    @Override
    public String toString() {
        return "Dean{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
