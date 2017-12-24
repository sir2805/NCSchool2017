package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;

public interface GroupSemesterJournalService {

    GroupSemesterJournal getSemesterJournalForGroup(Group group);

    void putMark(GroupSemesterJournal semesterJournal, Student student, Subject subject, String lessonName, Mark mark);
}
