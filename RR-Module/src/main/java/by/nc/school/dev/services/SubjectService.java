package by.nc.school.dev.services;

import by.nc.school.dev.builders.SubjectBuilder;
import by.nc.school.dev.entities.factories.TutorFactory;
import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.dao.entities.SubjectDaoEntity;
import by.nc.school.dev.entities.Subject;
import by.nc.school.dev.entities.Tutor;

import java.util.ArrayList;
import java.util.List;

public class SubjectService {

    public List<Subject> getTutorSubjects(Tutor tutor) {
        List<Subject> result = new ArrayList<>();
        SubjectBuilder subjectBuilder = new SubjectBuilder();
        int tutorId = tutor.getId();
        List<SubjectDaoEntity> daoEntities = new DaoFactory().getSubjectDao().getSubjectsByTutorId(tutorId);
        for (SubjectDaoEntity entity : daoEntities) {
            result.add(subjectBuilder.build(entity));
        }
        return result;
    }

    public Subject getSubjectByName(String subjectName) {
        SubjectDaoEntity subjectDaoEntity = new DaoFactory().getSubjectDao().getSubjectBySubjectName(subjectName);
        if (subjectDaoEntity != null) {
            Tutor tutor = (Tutor) new TutorFactory().build(new DaoFactory().getUserDao().get(subjectDaoEntity.getId()));
            return new Subject(subjectDaoEntity.getId(), subjectDaoEntity.getName(), tutor);
        }
        return null;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> result = new ArrayList<>();
        SubjectBuilder subjectBuilder = new SubjectBuilder();
        List<SubjectDaoEntity> daoEntities = new DaoFactory().getSubjectDao().getAllSubjects();
        for (SubjectDaoEntity entity : daoEntities) {
            result.add(subjectBuilder.build(entity));
        }
        return result;
    }
}
