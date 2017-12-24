package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupJournalRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public class GroupJournalServiceimpl implements GroupJournalService {

    protected GroupJournalRepository groupJournalRepository;

    protected GroupSemesterJournalService groupSemesterJournalService;

    @Override
    @Transactional
    public void initGroupJournal(Group group, GroupWorkPlan groupWorkPlan) {
        GroupJournal groupJournal = new GroupJournal(group, groupWorkPlan);

        Map<Semester, GroupSemesterJournal> groupJournalMap = new HashMap<>();
        Map<Semester, GroupSemesterWorkPlan> workPlanMap =  groupWorkPlan.getPlan();
        for (Semester semester : workPlanMap.keySet()) {
            groupJournalMap.put(semester, groupSemesterJournalService
                    .initGroupSemesterJournalFromGroupAndGroupSemesterWorkPlan(group, workPlanMap.get(semester)));
        }
        groupJournal.setGroupJournalMap(groupJournalMap);
        groupJournalRepository.save(groupJournal);
    }

    @Required
    public void setGroupJournalRepository(GroupJournalRepository groupJournalRepository) {
        this.groupJournalRepository = groupJournalRepository;
    }

    @Required
    public void setGroupSemesterJournalService(GroupSemesterJournalService groupSemesterJournalService) {
        this.groupSemesterJournalService = groupSemesterJournalService;
    }


}
