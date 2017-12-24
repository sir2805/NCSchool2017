package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "group_work_plan")
public class GroupWorkPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(
            name = "semester_group_semester_work_plan",
            joinColumns = @JoinColumn(name = "group_work_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "group_semester_work_plan_id"))
    private Map<Semester, GroupSemesterWorkPlan> plan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    public GroupWorkPlan() {

    }

    public GroupWorkPlan(Group group) {
        this.group = group;
        plan = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public Map<Semester, GroupSemesterWorkPlan> getPlan() {
        return plan;
    }

    public void setPlan(Map<Semester, GroupSemesterWorkPlan> plan) {
        this.plan = plan;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
