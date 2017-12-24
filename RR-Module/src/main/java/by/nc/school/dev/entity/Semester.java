package by.nc.school.dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "semester_number")
    private int semesterNumber;

    public Semester() {
        this.semesterNumber = 1;
    }

    public Semester(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Long getId() {
        return id;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semester)) return false;

        Semester semester = (Semester) o;

        if (semesterNumber != semester.semesterNumber) return false;
        return id != null ? id.equals(semester.id) : semester.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + semesterNumber;
        return result;
    }
}
