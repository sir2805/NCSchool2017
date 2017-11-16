package by.nc.school.dev.services;

import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.dao.JournalDao;
import by.nc.school.dev.dao.builders.JournalDaoEntityBuilder;
import by.nc.school.dev.dao.entities.JournalDaoEntity;
import by.nc.school.dev.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkService {

    public List<Mark> getMarks(Student student, Subject subject, GroupSemesterJournal groupSemesterJournal) {
        Map<Subject, GroupSubjectJournal> journal = groupSemesterJournal.getJournal();
        return journal.get(subject).getStudentMarks(student);
    }

    public Mark getExamMark(Student student, Subject subject, GroupSemesterJournal groupSemesterJournal) {
        List<Mark>marks = getMarks(student, subject, groupSemesterJournal);
        for (Mark mark : marks) {
            if (mark.getIsExam()) {
                return mark;
            }
        }
        return null;
    }

    public Map<Subject, List<Mark>> getAllMarks(Student student, GroupSemesterJournal groupSemesterJournal) {
        Map<Subject, List<Mark>> result = new HashMap<>();
        Map<Subject, GroupSubjectJournal> journal = groupSemesterJournal.getJournal();
        for (Subject subject : journal.keySet()) {
            result.put(subject, journal.get(subject).getStudentMarks(student));
        }
        return result;
    }

    public void putMark(Tutor tutor, Mark mark, Subject subject, Student student, GroupSemesterJournal groupSemesterJournal) {
        if (!tutor.equals(subject.getTutor())) {
            System.out.println("You are not allowed to put mark on subject you are not conducting");
            return;
        }
        Map<Subject, GroupSubjectJournal> journal = groupSemesterJournal.getJournal();
        GroupSubjectJournal groupSubjectJournal = journal.get(subject);
        if (groupSubjectJournal == null) {
            throw new RuntimeException("groupSubjectJournal is null");
        }
        groupSubjectJournal.getMarksList().get(student).add(mark);
        JournalDaoEntity journalDaoEntity = new JournalDaoEntityBuilder().build(mark, subject, student);
        JournalDao journalDao = new DaoFactory().getJournalDao();
        journalDao.create(journalDaoEntity);
        //TODO dao integration
    }
}
