package by.nc.school.dev.entity;

import by.nc.school.dev.Role;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "dean")
public class Dean extends Person {

    public Dean(String fullname, int role) {
        super(fullname, role);
    }

    public Dean(String fullname) {
        this.fullname = fullname;
        this.role = Role.DEAN;
    }

    Dean() {
        super();
    }

    @Override
    public String toString() {
        return "Dean{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
