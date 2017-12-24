package by.nc.school.dev.service;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupJournal;
import by.nc.school.dev.repository.GroupJournalRepository;
import org.springframework.beans.factory.annotation.Required;

public class GroupJournalServiceimpl implements GroupJournalService {

    protected GroupJournalRepository groupJournalRepository;

    @Override
    public void initGroupJournal(Group group) {

        GroupJournal groupJournal = new GroupJournal(null, group);
    }

    @Required
    public void setGroupJournalRepository(GroupJournalRepository groupJournalRepository) {
        this.groupJournalRepository = groupJournalRepository;
    }
}
