package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;

public interface GroupJournalService {

    void initGroupJournal(Group group, GroupWorkPlan groupWorkPlan);

    GroupJournal initGroupJournalFromGroupWorkPlan(GroupWorkPlan groupWorkPlan);

    void addEmptyGroupSemesterJournal(Group group, Semester semester, GroupSemesterWorkPlan groupSemesterWorkPlan);

    void putMark(GroupJournal groupJournal, Semester semester, Student student, Subject subject, String lessonName, Mark mark);

    void addLesson(GroupJournal groupJournal, Semester semester, Subject subject, String lessonName);
}
