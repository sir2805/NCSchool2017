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
            joinColumns = @JoinColumn(name = "group_semester_journal_id"),
            inverseJoinColumns = @JoinColumn(name = "group_subject_journal_id"))
    @MapKeyColumn(name = "subject_id")
    private Map<Subject, GroupSubjectJournal> semesterJournal;

    public GroupSemesterJournal() {
        semesterJournal = new HashMap<>();
    }

    public Long getId() {
        return id;
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
