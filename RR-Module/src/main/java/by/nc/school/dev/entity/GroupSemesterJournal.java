package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "group_semester_journal")
public class GroupSemesterJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "subject_group_subject_journal",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "group_subject_journal_id"))
    private Map<Subject, GroupSubjectJournal> semesterJournal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "semester_work_plan_for_group_id")
    private SemesterWorkPlanForGroup semesterWorkPlanForGroup;

    public GroupSemesterJournal() {
        semesterJournal = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public SemesterWorkPlanForGroup getSemesterWorkPlanForGroup() {
        return semesterWorkPlanForGroup;
    }

    public void setSemesterWorkPlanForGroup(SemesterWorkPlanForGroup semesterWorkPlanForGroup) {
        this.semesterWorkPlanForGroup = semesterWorkPlanForGroup;
    }

    public GroupSemesterJournal(Map<Subject, GroupSubjectJournal> semesterJournal) {
        this.semesterJournal = semesterJournal;
    }

    public Map<Subject, GroupSubjectJournal> getSemesterJournal() {
        return semesterJournal;
    }

    public void setSemesterJournal(Map<Subject, GroupSubjectJournal> semesterJournal) {
        this.semesterJournal = semesterJournal;
    }
}
