package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupSubjectJournal;

public interface GroupSubjectJournalService {

    void saveGroupSubjectJournal(GroupSubjectJournal subjectJournal);

    GroupSubjectJournal initGroupSubjectJournalFromGroup(Group group);
}
