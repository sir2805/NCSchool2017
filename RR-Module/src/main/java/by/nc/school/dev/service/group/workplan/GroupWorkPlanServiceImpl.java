package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupWorkPlan;
import by.nc.school.dev.entity.Semester;
import by.nc.school.dev.entity.GroupSemesterWorkPlan;
import by.nc.school.dev.repository.GroupWorkPlanRepository;
import org.springframework.beans.factory.annotation.Required;

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
    public void addSemesterWorkPlanForGroup(Group group, Semester semester, GroupSemesterWorkPlan groupSemesterWorkPlan) {
        GroupWorkPlan groupWorkPlan = groupWorkPlanRepository.findByGroup(group);
        if (groupWorkPlan == null) {
            groupWorkPlan = new GroupWorkPlan(group);
        }
        groupWorkPlan.getPlan().put(semester, groupSemesterWorkPlan);
        groupSemesterWorkPlanService.saveSemesterWorkPlanForGroup(groupSemesterWorkPlan);
        groupWorkPlanRepository.save(groupWorkPlan);
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
