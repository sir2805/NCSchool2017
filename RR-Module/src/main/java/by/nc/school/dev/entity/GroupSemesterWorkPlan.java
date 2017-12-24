package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semester_work_plan_for_group")
public class GroupSemesterWorkPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tutor_and_subject_list",
            joinColumns = @JoinColumn(name = "work_plan_for_group_id"),
            inverseJoinColumns = @JoinColumn(name = "tutor_and_subject_id"))
    private List<TutorAndSubject> tutorAndSubjectList;

    public GroupSemesterWorkPlan() {
    }

    public GroupSemesterWorkPlan(List<TutorAndSubject> tutorAndSubjectList) {
        this.tutorAndSubjectList = tutorAndSubjectList;
    }

    public Long getId() {
        return id;
    }

    public List<TutorAndSubject> getTutorAndSubjectList() {
        return tutorAndSubjectList;
    }

    public void setTutorAndSubjectList(List<TutorAndSubject> tutorAndSubjectList) {
        this.tutorAndSubjectList = tutorAndSubjectList;
    }
}
