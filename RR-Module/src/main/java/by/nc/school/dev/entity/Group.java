package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "group_number")
    private int groupNumber;
    @OneToMany(cascade = CascadeType.ALL)
    //TODO configure JoinTable
    private List<Student> students;
    @OneToOne
    private Curator curator;
    @ManyToOne
    private Semester currentSemester;

    public Group(int groupNumber, List<Student> students, Curator curator, Semester currentSemester) {
        this.groupNumber = groupNumber;
        this.students = students;
        this.curator = curator;
        this.currentSemester = currentSemester;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", students=" + students +
                ", curator=" + curator +
                ", currentSemester=" + currentSemester +
                '}';
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
