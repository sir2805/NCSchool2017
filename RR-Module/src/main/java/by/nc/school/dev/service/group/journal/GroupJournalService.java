package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupWorkPlan;

public interface GroupJournalService {

    void initGroupJournal(Group group, GroupWorkPlan groupWorkPlan);
}
