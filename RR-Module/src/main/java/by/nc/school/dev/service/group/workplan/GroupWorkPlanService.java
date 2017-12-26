package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.*;

import java.util.List;

public interface GroupWorkPlanService {

    GroupWorkPlan initGroupWorkPlanFromGroupSemesterWorkPlan(Group group, GroupSemesterWorkPlan groupSemesterWorkPlan);

    GroupWorkPlan initGroupWorkPlanFromGroup(Group group);

    GroupWorkPlan addSemesterWorkPlanForGroup(Group group, Semester semester, List<TutorAndSubject> tutorAndSubjectList);
}
