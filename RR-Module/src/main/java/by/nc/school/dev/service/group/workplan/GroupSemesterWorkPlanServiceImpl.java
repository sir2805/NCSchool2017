package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.GroupSemesterWorkPlan;
import by.nc.school.dev.repository.GroupSemesterWorkPlanRepository;
import org.springframework.beans.factory.annotation.Required;


public class GroupSemesterWorkPlanServiceImpl implements GroupSemesterWorkPlanService {

    protected GroupSemesterWorkPlanRepository groupSemesterWorkPlanRepository;

    @Override
    public void saveSemesterWorkPlanForGroup(GroupSemesterWorkPlan groupSemesterWorkPlan) {
        groupSemesterWorkPlanRepository.save(groupSemesterWorkPlan);
    }


    @Required
    public void setGroupSemesterWorkPlanRepository(GroupSemesterWorkPlanRepository groupSemesterWorkPlanRepository) {
        this.groupSemesterWorkPlanRepository = groupSemesterWorkPlanRepository;
    }

}
