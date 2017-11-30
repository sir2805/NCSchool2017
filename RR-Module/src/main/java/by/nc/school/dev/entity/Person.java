package by.nc.school.dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "fullname")
    protected String fullname;
    @Column(name = "role")
    protected int role;

    public Person(Long id, String fullname, int role) {
        this.id = id;
        this.fullname = fullname;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (role != person.role) return false;
        return fullname != null ? fullname.equals(person.fullname) : person.fullname == null;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}
