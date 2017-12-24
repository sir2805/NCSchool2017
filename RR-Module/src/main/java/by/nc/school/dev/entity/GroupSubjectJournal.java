package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            joinColumns = @JoinColumn(name = "group_subject_journal_id"),
            inverseJoinColumns = @JoinColumn(name = "list_of_marks_id"))
    @MapKeyColumn(name = "student_id")
    private Map<Student, ListOfMarks> marksList;

    @ElementCollection
    @JoinTable(name = "lesson_names",
            joinColumns = @JoinColumn(name = "lesson_names_id")
    )
    private List<String> lessonNames = new ArrayList<>();

    public List<String> getLessonNames() {
        return lessonNames;
    }

    public void setLessonNames(List<String> lessonNames) {
        this.lessonNames = lessonNames;
    }

    public Long getId() {
        return id;
    }

    public GroupSubjectJournal() {
        marksList = new HashMap<>();
        lessonNames = new ArrayList<>();
    }

    public Map<Student, ListOfMarks> getMarksList() {
        return marksList;
    }

    public void setMarksList(Map<Student, ListOfMarks> marksList) {
        this.marksList = marksList;
    }
}
