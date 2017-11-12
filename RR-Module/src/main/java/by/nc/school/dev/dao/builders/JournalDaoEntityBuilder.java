package by.nc.school.dev.dao.builders;

import by.nc.school.dev.dao.JournalDao;
import by.nc.school.dev.enitities.Mark;
import by.nc.school.dev.enitities.Student;
import by.nc.school.dev.enitities.Subject;

public class JournalDaoEntityBuilder {

    public JournalDao build(Mark mark, Subject subject, Student student) {
        int subjectId = subject.getId();
        int studentId = student.getId();
        int markValue = mark.getMark();
        boolean isExam = mark.getIsExam();
        return new JournalDao((int)System.currentTimeMillis(), subjectId, studentId, markValue, isExam);
    }
}
