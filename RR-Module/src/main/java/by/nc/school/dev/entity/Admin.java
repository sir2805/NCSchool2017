package by.nc.school.dev.entity;

import by.nc.school.dev.Role;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "admin")
public class Admin extends Person {

    public Admin(String fullname, int role) {
        super(fullname, role);
    }

    public Admin(String fullname) {
//        this.id = UUID.randomUUID().getMostSignificantBits();
        this.fullname = fullname;
        this.role = Role.ADMIN;
    }

    Admin() {
        super();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
