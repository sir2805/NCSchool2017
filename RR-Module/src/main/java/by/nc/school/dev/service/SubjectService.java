package by.nc.school.dev.service;

import by.nc.school.dev.entity.Subject;

public interface SubjectService {

    void addSubject(String name);

    Subject getSubjectByName(String subjectName);

    Subject getSubjectById(Long id);
}
