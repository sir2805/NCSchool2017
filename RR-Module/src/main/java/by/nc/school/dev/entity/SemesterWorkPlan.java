package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semester_work_plan")
public class SemesterWorkPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "semester_work_plan_for_group_list",
            joinColumns = @JoinColumn(name = "semester_work_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "semester_work_plan_for_group_id"))
    private List<SemesterWorkPlanForGroup> plan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    public SemesterWorkPlan() {
        plan = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<SemesterWorkPlanForGroup> getPlan() {
        return plan;
    }

    public void setPlan(List<SemesterWorkPlanForGroup> plan) {
        this.plan = plan;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SemesterWorkPlan{" +
                "id=" + id +
                ", plan=" + plan +
                ", semester=" + semester +
                '}';
    }
}
