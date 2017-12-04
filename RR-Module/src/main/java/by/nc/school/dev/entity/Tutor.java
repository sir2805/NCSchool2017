package by.nc.school.dev.entity;

import by.nc.school.dev.Role;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tutor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tutor extends Person {

    public Tutor(String fullname, int role) {
        super(fullname, role);
    }

    public Tutor(String fullname) {
        this.fullname = fullname;
        this.role = Role.TUTOR;
    }

    Tutor() {
        super();
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
