package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "group_journal")
public class GroupJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_journal_id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "semester_group_semester_journal",
            joinColumns = @JoinColumn(name = "semester_id"),
            inverseJoinColumns = @JoinColumn(name = "group_semester_journal_id"))
    private Map<Semester, GroupSemesterJournal>groupJournal;
    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private GroupJournal() {
        groupJournal = new HashMap<>();
    }

    public GroupJournal(Map<Semester, GroupSemesterJournal> groupJournal, Group group) {
        this.groupJournal = groupJournal;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public Map<Semester, GroupSemesterJournal> getGroupJournal() {
        return groupJournal;
    }

    public void setGroupJournal(Map<Semester, GroupSemesterJournal> groupJournal) {
        this.groupJournal = groupJournal;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "GroupJournal{" +
                "groupJournal=" + groupJournal +
                ", group=" + group +
                '}';
    }
}
