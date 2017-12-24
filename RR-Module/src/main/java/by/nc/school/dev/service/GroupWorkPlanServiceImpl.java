package by.nc.school.dev.service;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupWorkPlan;
import by.nc.school.dev.entity.Semester;
import by.nc.school.dev.entity.SemesterWorkPlanForGroup;
import by.nc.school.dev.repository.GroupWorkPlanRepository;
import org.springframework.beans.factory.annotation.Required;

public class GroupWorkPlanServiceImpl implements GroupWorkPlanService {

    protected GroupWorkPlanRepository groupWorkPlanRepository;

    protected SemesterWorkPlanForGroupService semesterWorkPlanForGroupService;

    @Override
    public void initGroupWorkPlan() {

    }

    @Override
    public void addSemesterWorkPlanForGroup(Group group, Semester semester, SemesterWorkPlanForGroup semesterWorkPlanForGroup) {
        GroupWorkPlan groupWorkPlan = groupWorkPlanRepository.findByGroup(group);
        if (groupWorkPlan == null) {
            groupWorkPlan = new GroupWorkPlan(group);
        }
        groupWorkPlan.getPlan().put(semester, semesterWorkPlanForGroup);
        semesterWorkPlanForGroupService.saveSemesterWorkPlanForGroup(semesterWorkPlanForGroup);
        groupWorkPlanRepository.save(groupWorkPlan);
    }

    @Required
    public void setGroupWorkPlanRepository(GroupWorkPlanRepository groupWorkPlanRepository) {
        this.groupWorkPlanRepository = groupWorkPlanRepository;
    }

    @Required
    public void setSemesterWorkPlanForGroupService(SemesterWorkPlanForGroupService semesterWorkPlanForGroupService) {
        this.semesterWorkPlanForGroupService = semesterWorkPlanForGroupService;
    }
}
