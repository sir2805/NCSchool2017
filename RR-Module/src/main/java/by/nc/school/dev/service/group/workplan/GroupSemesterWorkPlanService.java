package by.nc.school.dev.service.group.workplan;


import by.nc.school.dev.entity.GroupSemesterWorkPlan;
import by.nc.school.dev.entity.Subject;

import java.util.Set;


public interface GroupSemesterWorkPlanService {

    void saveSemesterWorkPlanForGroup(GroupSemesterWorkPlan groupSemesterWorkPlan);

    Set<Subject> getAllSubjects(GroupSemesterWorkPlan groupSemesterWorkPlan);
}
