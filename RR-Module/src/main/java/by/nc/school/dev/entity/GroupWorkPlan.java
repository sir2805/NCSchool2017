package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            name = "semester_semester_work_plan_for_group",
            joinColumns = @JoinColumn(name = "group_work_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "semester_work_plan_for_group_id"))
    private Map<Semester, SemesterWorkPlanForGroup> plan;

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

    public Map<Semester, SemesterWorkPlanForGroup> getPlan() {
        return plan;
    }

    public void setPlan(Map<Semester, SemesterWorkPlanForGroup> plan) {
        this.plan = plan;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
