package by.nc.school.dev.service;

import by.nc.school.dev.entity.Subject;
import by.nc.school.dev.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Required;

public class SubjectServiceImpl implements SubjectService {

    protected SubjectRepository subjectRepository;
    @Override
    public void addSubject(String name) {
        Subject subject = new Subject(name);
        subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        return subjectRepository.findByName(subjectName);
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Required
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
}
