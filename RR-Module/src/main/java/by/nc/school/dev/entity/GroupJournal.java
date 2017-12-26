package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "group_journal")
public class GroupJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "semester_group_semester_journal",
            joinColumns = @JoinColumn(name = "group_journal_id"),
            inverseJoinColumns = @JoinColumn(name = "group_semester_journal_id"))
    @MapKeyColumn(name = "semester_id")
    private Map<Semester, GroupSemesterJournal> groupJournalMap;

    @OneToOne
    @JoinColumn(name = "group_work_plan_id")
    private GroupWorkPlan groupWorkPlan;


    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public GroupJournal() {
        groupJournalMap = new HashMap<>();
    }

    public GroupJournal(Group group, GroupWorkPlan groupWorkPlan) {
        this.groupJournalMap = new HashMap<>();
        this.groupWorkPlan = groupWorkPlan;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public Map<Semester, GroupSemesterJournal> getGroupJournalMap() {
        return groupJournalMap;
    }

    public GroupWorkPlan getGroupWorkPlan() {
        return groupWorkPlan;
    }

    public void setGroupWorkPlan(GroupWorkPlan groupWorkPlan) {
        this.groupWorkPlan = groupWorkPlan;
    }

    public void setGroupJournalMap(Map<Semester, GroupSemesterJournal> groupJournalMap) {
        this.groupJournalMap = groupJournalMap;
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
                "groupJournalMap=" + groupJournalMap +
                ", group=" + group +
                '}';
    }
}
