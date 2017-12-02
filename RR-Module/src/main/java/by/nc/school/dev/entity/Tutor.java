package by.nc.school.dev.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tutor extends Person {

    @Override
    public String toString() {
        return "Tutor{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
