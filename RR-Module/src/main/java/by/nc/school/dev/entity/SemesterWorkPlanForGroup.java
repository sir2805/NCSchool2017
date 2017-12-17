package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semester_work_plan_for_group")
public class SemesterWorkPlanForGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tutor_and_subject_list",
            joinColumns = @JoinColumn(name = "tutor_and_subject_list_id"),
            inverseJoinColumns = @JoinColumn(name = "work_plan_for_group_id"))
    private List<TutorAndSubject> tutorAndSubjectList;

    public Long getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<TutorAndSubject> getTutorAndSubjectList() {
        return tutorAndSubjectList;
    }

    public void setTutorAndSubjectList(List<TutorAndSubject> tutorAndSubjectList) {
        this.tutorAndSubjectList = tutorAndSubjectList;
    }
}
