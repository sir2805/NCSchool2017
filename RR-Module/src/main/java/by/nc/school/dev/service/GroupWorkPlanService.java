package by.nc.school.dev.service;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Semester;
import by.nc.school.dev.entity.SemesterWorkPlanForGroup;

public interface GroupWorkPlanService {

    void initGroupWorkPlan();

    void addSemesterWorkPlanForGroup(Group group, Semester semester, SemesterWorkPlanForGroup semesterWorkPlanForGroup);
}
