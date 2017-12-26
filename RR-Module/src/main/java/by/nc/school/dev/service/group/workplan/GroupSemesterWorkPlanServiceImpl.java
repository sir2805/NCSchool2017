package by.nc.school.dev.service.group.workplan;

import by.nc.school.dev.entity.GroupSemesterWorkPlan;
import by.nc.school.dev.entity.Subject;
import by.nc.school.dev.entity.TutorAndSubject;
import by.nc.school.dev.repository.GroupSemesterWorkPlanRepository;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GroupSemesterWorkPlanServiceImpl implements GroupSemesterWorkPlanService {

    protected GroupSemesterWorkPlanRepository groupSemesterWorkPlanRepository;

    protected TutorAndSubjectService tutorAndSubjectService;

    @Override
    public void saveSemesterWorkPlanForGroup(GroupSemesterWorkPlan groupSemesterWorkPlan) {
        groupSemesterWorkPlanRepository.save(groupSemesterWorkPlan);
    }

    @Override
    public GroupSemesterWorkPlan initGroupSemesterWorkPlan() {
        GroupSemesterWorkPlan groupSemesterWorkPlan = new GroupSemesterWorkPlan();
        groupSemesterWorkPlanRepository.save(groupSemesterWorkPlan);
        return groupSemesterWorkPlan;
    }

    @Override
    @Transactional
    public GroupSemesterWorkPlan addTutorAndSubjectList(GroupSemesterWorkPlan groupSemesterWorkPlan, List<TutorAndSubject> tutorAndSubjectList) {
        tutorAndSubjectService.saveAll(tutorAndSubjectList);
        groupSemesterWorkPlan.setTutorAndSubjectList(tutorAndSubjectList);
        groupSemesterWorkPlanRepository.save(groupSemesterWorkPlan);
        return groupSemesterWorkPlan;
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

    @Required
    public void setTutorAndSubjectService(TutorAndSubjectService tutorAndSubjectService) {
        this.tutorAndSubjectService = tutorAndSubjectService;
    }
}
