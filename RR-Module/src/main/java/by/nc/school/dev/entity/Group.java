package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "group_number")
    private int groupNumber;
    @OneToMany(mappedBy = "group")
    private List<Student> students;
    @OneToOne(mappedBy = "group")
    private Curator curator;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "semester_id")
    private Semester currentSemester;

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", students=" + students +
                ", curator=" + curator +
                ", currentSemester=" + currentSemester +
                '}';
    }

    private Group() {
//        this.id = UUID.randomUUID().getMostSignificantBits();
        this.students = new ArrayList<>();
    }

    public Group(int groupNumber, Semester semester) {
//        this.id = UUID.randomUUID().getMostSignificantBits();
        this.groupNumber = groupNumber;
        this.currentSemester = semester;
        this.curator = null;
        this.students = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public Semester getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Semester currentSemester) {
        this.currentSemester = currentSemester;
    }
}
