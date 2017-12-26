package by.nc.school.dev.entity;

import by.nc.school.dev.Role;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "curator")
public class Curator extends Tutor {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id")
    private Group group;

    public Curator(String fullname, int role, Group group) {
        super(fullname, role);
        this.group = group;
    }

    public Curator(String fullname, Group group) {
        this.fullname = fullname;
        this.role = Role.CURATOR;
        this.group = group;
    }

    private Curator() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curator)) return false;
        if (!super.equals(o)) return false;

        Curator curator = (Curator) o;

        return group != null ? group.equals(curator.group) : curator.group == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
