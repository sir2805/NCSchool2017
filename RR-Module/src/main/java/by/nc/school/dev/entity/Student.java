package by.nc.school.dev.entity;

import by.nc.school.dev.Role;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String fullname, int role, Group group) {
        super(fullname, role);
        this.group = group;
    }

    public Student(String fullname, Group group) {
        this.fullname = fullname;
        this.role = Role.STUDENT;
        this.group = group;
    }

    Student() {
        super();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return fullname + " from group " + String.valueOf(group.getGroupNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return this.id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
