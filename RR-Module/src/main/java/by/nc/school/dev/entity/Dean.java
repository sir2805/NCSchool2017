package by.nc.school.dev.entity;

import javax.persistence.Entity;

@Entity
public class Dean extends Person {

    public Dean(String fullname, int role) {
        super(fullname, role);
    }

    @Override
    public String toString() {
        return "Dean{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
