package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Semester;
import by.nc.school.dev.entity.GroupSemesterWorkPlan;

public interface GroupWorkPlanService {

    void initGroupWorkPlan();

    void addSemesterWorkPlanForGroup(Group group, Semester semester, GroupSemesterWorkPlan groupSemesterWorkPlan);
}
