package by.nc.school.dev.entities;

public class Semester extends BaseEntity {

    private int semesterNumber;

    public Semester(int id, int semesterNumber) {
        super(id);
        this.semesterNumber = semesterNumber;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }
}
