package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupWorkPlanRepository;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;
import java.util.List;

public class GroupWorkPlanServiceImpl implements GroupWorkPlanService {

    protected GroupWorkPlanRepository groupWorkPlanRepository;

    protected GroupSemesterWorkPlanService groupSemesterWorkPlanService;

    @Override
    public GroupWorkPlan initGroupWorkPlanFromGroupSemesterWorkPlan(Group group, GroupSemesterWorkPlan groupSemesterWorkPlan) {
        GroupWorkPlan groupWorkPlan = new GroupWorkPlan(group);
        groupWorkPlan.getPlan().put(group.getCurrentSemester(), groupSemesterWorkPlan);
        groupSemesterWorkPlanService.saveSemesterWorkPlanForGroup(groupSemesterWorkPlan);
        groupWorkPlanRepository.save(groupWorkPlan);
        return groupWorkPlan;
    }

    @Override
    public GroupWorkPlan initGroupWorkPlanFromGroup(Group group) {
        GroupWorkPlan groupWorkPlan = new GroupWorkPlan(group);
        groupWorkPlan.getPlan().put(group.getCurrentSemester(), groupSemesterWorkPlanService.initGroupSemesterWorkPlan());
        groupWorkPlanRepository.save(groupWorkPlan);
        return groupWorkPlan;
    }

    @Override
    @Transactional
    public GroupWorkPlan addSemesterWorkPlanForGroup(Group group, Semester semester, List<TutorAndSubject> tutorAndSubjectList) {
        GroupWorkPlan groupWorkPlan = groupWorkPlanRepository.findByGroup(group);
        if (groupWorkPlan == null) {
            groupWorkPlan = initGroupWorkPlanFromGroup(group);
        }
        GroupSemesterWorkPlan groupSemesterWorkPlan = groupWorkPlan.getPlan().get(semester);
        if (groupSemesterWorkPlan == null) {
           groupSemesterWorkPlan = groupSemesterWorkPlanService.initGroupSemesterWorkPlan();
        }
        groupWorkPlan.getPlan().put(semester, groupSemesterWorkPlanService.addTutorAndSubjectList(groupSemesterWorkPlan, tutorAndSubjectList));
        groupWorkPlanRepository.save(groupWorkPlan);
        return groupWorkPlan;
    }

    @Override
    public boolean isWorkPlanForGroupExists(Group group) {
        GroupWorkPlan groupWorkPlan =  groupWorkPlanRepository.findByGroup(group);
        if (groupWorkPlan == null) {
            return false;
        } else {
            return !(groupWorkPlan.getPlan().get(group.getCurrentSemester()).getTutorAndSubjectList().size() == 0);
        }
    }

    @Required
    public void setGroupWorkPlanRepository(GroupWorkPlanRepository groupWorkPlanRepository) {
        this.groupWorkPlanRepository = groupWorkPlanRepository;
    }

    @Required
    public void setGroupSemesterWorkPlanService(GroupSemesterWorkPlanService groupSemesterWorkPlanService) {
        this.groupSemesterWorkPlanService = groupSemesterWorkPlanService;
    }
}
