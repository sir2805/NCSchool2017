package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;

public interface GroupSubjectJournalService {

    void saveGroupSubjectJournal(GroupSubjectJournal subjectJournal);

    GroupSubjectJournal initGroupSubjectJournalFromGroup(Group group);

    void putMark(GroupSubjectJournal groupSubjectJournal, Student student, String lessonName, Mark mark);

    void addLesson(GroupSubjectJournal groupSubjectJournal, String lessonName);
}
