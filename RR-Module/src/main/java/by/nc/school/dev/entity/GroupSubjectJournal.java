package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "group_subject_journal")
public class GroupSubjectJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_list_of_marks",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "list_of_marks_id"))
    private Map<Student, ListOfMarks> marksList;

    public Long getId() {
        return id;
    }

    public GroupSubjectJournal() {
        marksList = new HashMap<>();
    }

    public Map<Student, ListOfMarks> getMarksList() {
        return marksList;
    }

    public void setMarksList(Map<Student, ListOfMarks> marksList) {
        this.marksList = marksList;
    }
}
