package by.nc.school.dev.entity;

import javax.persistence.Entity;

@Entity
public class Dean extends Person {

    @Override
    public String toString() {
        return "Dean{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
