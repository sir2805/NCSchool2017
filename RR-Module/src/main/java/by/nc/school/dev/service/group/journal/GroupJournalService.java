package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;

public interface GroupJournalService {

    void initGroupJournal(Group group, GroupWorkPlan groupWorkPlan);

    void putMark(GroupJournal groupJournal, Semester semester, Student student, Subject subject, String lessonName, Mark mark);

    void addLesson(GroupJournal groupJournal, Semester semester, Subject subject, String lessonName);
}
