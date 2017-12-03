package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "list_of_marks")
public class ListOfMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_of_marks_id")
    private Long id;
    @ElementCollection
    @JoinTable(name = "mark",
        joinColumns = @JoinColumn(name = "list_of_marks_id")
    )
    private List<Mark> marksList;

    public Long getId() {
        return id;
    }

    public ListOfMarks() {
        this.marksList = new ArrayList<>();
    }

    public List<Mark> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Mark> marksList) {
        this.marksList = marksList;
    }
}
