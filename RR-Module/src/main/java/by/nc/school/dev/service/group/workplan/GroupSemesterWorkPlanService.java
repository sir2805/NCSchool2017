package by.nc.school.dev.service.group.workplan;


import by.nc.school.dev.entity.*;

import java.util.List;
import java.util.Set;


public interface GroupSemesterWorkPlanService {

    void saveSemesterWorkPlanForGroup(GroupSemesterWorkPlan groupSemesterWorkPlan);

    GroupSemesterWorkPlan initGroupSemesterWorkPlan();

    GroupSemesterWorkPlan addTutorAndSubjectList(GroupSemesterWorkPlan groupSemesterWorkPlan, List<TutorAndSubject> tutorAndSubjectList);

    Set<Subject> getAllSubjects(GroupSemesterWorkPlan groupSemesterWorkPlan);
}
