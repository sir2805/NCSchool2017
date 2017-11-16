package by.nc.school.dev.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupSubjectJournal {

    private Map<Student, List<Mark>> marksList;
    private Tutor tutor;

    public GroupSubjectJournal(Subject subject) {
        marksList = new HashMap<>();
        tutor = subject.getTutor();
    }

    public GroupSubjectJournal(Map<Student, List<Mark>> marksList, Tutor tutor) {
        this.marksList = marksList;
        this.tutor = tutor;
    }

    public GroupSubjectJournal(List<Student> students, Tutor tutor) {
        this.marksList = new HashMap<>();
        for (Student student : students) {
            marksList.put(student, new ArrayList<>());
        }
        this.tutor = tutor;
    }

    public void setMarksList(Map<Student, List<Mark>> marksList) {
        this.marksList = marksList;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Map<Student, List<Mark>> getMarksList() {
        return marksList;
    }

    public List<Mark> getStudentMarks(Student student) {
        return marksList.get(student);
    }
}
