package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;

public interface GroupSemesterJournalService {

    GroupSemesterJournal initGroupSemesterJournalFromGroupAndGroupSemesterWorkPlan(Group group, GroupSemesterWorkPlan groupSemesterWorkPlan);

    GroupSemesterJournal getSemesterJournalForGroup(Group group);

    void putMark(GroupSemesterJournal semesterJournal, Student student, Subject subject, String lessonName, Mark mark);

    void addLesson(GroupSemesterJournal semesterJournal, Subject subject, String lessonName);
}
