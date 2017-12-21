package by.nc.school.dev.entity;

import by.nc.school.dev.Role;

import javax.persistence.*;

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
        return "Student{" +
                "group=" + group +
                ", id=" + id +
                ", fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return group != null ? group.equals(student.group) : student.group == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
