package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.GroupSemesterWorkPlan;
import by.nc.school.dev.entity.Subject;
import by.nc.school.dev.entity.TutorAndSubject;
import by.nc.school.dev.repository.GroupSemesterWorkPlanRepository;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashSet;
import java.util.Set;


public class GroupSemesterWorkPlanServiceImpl implements GroupSemesterWorkPlanService {

    protected GroupSemesterWorkPlanRepository groupSemesterWorkPlanRepository;

    @Override
    public void saveSemesterWorkPlanForGroup(GroupSemesterWorkPlan groupSemesterWorkPlan) {
        groupSemesterWorkPlanRepository.save(groupSemesterWorkPlan);
    }

    @Override
    public Set<Subject> getAllSubjects(GroupSemesterWorkPlan groupSemesterWorkPlan) {
        Set<Subject> subjects = new HashSet<>();
        for(TutorAndSubject tutorAndSubject : groupSemesterWorkPlan.getTutorAndSubjectList()) {
            subjects.add(tutorAndSubject.getSubject());
        }
        return subjects;
    }

    @Required
    public void setGroupSemesterWorkPlanRepository(GroupSemesterWorkPlanRepository groupSemesterWorkPlanRepository) {
        this.groupSemesterWorkPlanRepository = groupSemesterWorkPlanRepository;
    }

}
