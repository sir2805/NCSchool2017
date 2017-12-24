package by.nc.school.dev.service;

import by.nc.school.dev.entity.SemesterWorkPlanForGroup;
import by.nc.school.dev.repository.SemesterWorkPlanForGroupRepository;
import org.springframework.beans.factory.annotation.Required;


public class SemesterWorkPlanForGroupServiceImpl implements SemesterWorkPlanForGroupService {

    protected SemesterWorkPlanForGroupRepository semesterWorkPlanForGroupRepository;

    @Override
    public void saveSemesterWorkPlanForGroup(SemesterWorkPlanForGroup semesterWorkPlanForGroup) {
        semesterWorkPlanForGroupRepository.save(semesterWorkPlanForGroup);
    }


    @Required
    public void setSemesterWorkPlanForGroupRepository(SemesterWorkPlanForGroupRepository semesterWorkPlanForGroupRepository) {
        this.semesterWorkPlanForGroupRepository = semesterWorkPlanForGroupRepository;
    }

}
