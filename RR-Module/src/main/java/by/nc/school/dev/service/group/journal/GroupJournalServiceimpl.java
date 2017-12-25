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

    @Override
    public void putMark(GroupJournal groupJournal, Semester semester, Student student, Subject subject, String lessonName, Mark mark) {
        groupSemesterJournalService.putMark(groupJournal.getGroupJournalMap().get(semester), student, subject, lessonName, mark);
    }

    @Override
    public void addLesson(GroupJournal groupJournal, Semester semester, Subject subject, String lessonName) {
        groupSemesterJournalService.addLesson(groupJournal.getGroupJournalMap().get(semester), subject, lessonName);
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
