package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupJournalRepository;
import by.nc.school.dev.repository.GroupSemesterJournalRepository;
import by.nc.school.dev.repository.GroupSubjectJournalRepository;
import by.nc.school.dev.service.group.workplan.GroupSemesterWorkPlanService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupSemesterJournalServiceImpl implements GroupSemesterJournalService {

    protected GroupSemesterJournalRepository groupSemesterJournalRepository;

    protected GroupSubjectJournalService groupSubjectJournalService;

    protected GroupSemesterWorkPlanService groupSemesterWorkPlanService;

    @Override
    public GroupSemesterJournal initGroupSemesterJournalFromGroupAndGroupSemesterWorkPlan(Group group, GroupSemesterWorkPlan groupSemesterWorkPlan) {
        GroupSemesterJournal groupSemesterJournal = new GroupSemesterJournal();
        Set<Subject> subjects = groupSemesterWorkPlanService.getAllSubjects(groupSemesterWorkPlan);
        Map<Subject, GroupSubjectJournal> semesterJournalMap = new HashMap<>();
        for (Subject subject : subjects) {
            semesterJournalMap.put(subject, groupSubjectJournalService.initGroupSubjectJournalFromGroup(group));
        }
        groupSemesterJournal.setSemesterJournal(semesterJournalMap);
        groupSemesterJournalRepository.save(groupSemesterJournal);
        return groupSemesterJournal;
    }

    @Override
    public GroupSemesterJournal getSemesterJournalForGroup(Group group) {
        return null;
    }

    @Override
    public void putMark(GroupSemesterJournal semesterJournal, Student student, Subject subject, String lessonName, Mark mark) {
        groupSubjectJournalService.putMark(semesterJournal.getSemesterJournal().get(subject), student, lessonName, mark);
    }

    @Override
    public void addLesson(GroupSemesterJournal semesterJournal, Subject subject, String lessonName) {
        groupSubjectJournalService.addLesson(semesterJournal.getSemesterJournal().get(subject), lessonName);
    }

    @Required
    public void setGroupSemesterJournalRepository(GroupSemesterJournalRepository groupSemesterJournalRepository) {
        this.groupSemesterJournalRepository = groupSemesterJournalRepository;
    }

    @Required
    public void setGroupSubjectJournalService(GroupSubjectJournalService groupSubjectJournalService) {
        this.groupSubjectJournalService = groupSubjectJournalService;
    }

    @Required
    public void setGroupSemesterWorkPlanService(GroupSemesterWorkPlanService groupSemesterWorkPlanService) {
        this.groupSemesterWorkPlanService = groupSemesterWorkPlanService;
    }
}
