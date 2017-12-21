package by.nc.school.dev.service;

import by.nc.school.dev.entity.TutorAndSubject;
import by.nc.school.dev.repository.TutorAndSubjectRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TutorAndSubjectServiceImpl implements TutorAndSubjectService {

    protected TutorAndSubjectRepository tutorAndSubjectRepository;

    @Transactional
    @Override
    public void saveAll(List<TutorAndSubject> tutorAndSubjectList) {
        tutorAndSubjectRepository.saveAll(tutorAndSubjectList);
    }

    @Required
    public void setTutorAndSubjectRepository(TutorAndSubjectRepository tutorAndSubjectRepository) {
        this.tutorAndSubjectRepository = tutorAndSubjectRepository;
    }
}
