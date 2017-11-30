package by.nc.school.dev.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends Person {
    @ManyToOne
    private Group group;

    public Student(Long id, String fullName, int role, Group group) {
        super(id, fullName, role);
        this.group = group;
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