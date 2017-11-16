package by.nc.school.dev.builders;

import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.dao.entities.SubjectDaoEntity;
import by.nc.school.dev.dao.entities.UserDaoEntity;
import by.nc.school.dev.entities.Subject;
import by.nc.school.dev.entities.Tutor;
import by.nc.school.dev.entities.factories.TutorFactory;

public class SubjectBuilder {
    public Subject build(SubjectDaoEntity subjectDaoEntity) {
        UserDaoEntity tutorDaoEntity = new DaoFactory().getUserDao().get(subjectDaoEntity.getTutorId());
        Tutor tutor = (Tutor) new TutorFactory().build(tutorDaoEntity);
        return new Subject(subjectDaoEntity.getId(), subjectDaoEntity.getName(), tutor);
    }

    public Subject build(String subjectName) {
        SubjectDaoEntity subjectDaoEntity = new DaoFactory().getSubjectDao().getSubjectBySubjectName(subjectName);
        UserDaoEntity tutorDaoEntity = new DaoFactory().getUserDao().get(subjectDaoEntity.getTutorId());
        Tutor tutor = (Tutor) new TutorFactory().build(tutorDaoEntity);
        return new Subject(subjectDaoEntity.getId(), subjectDaoEntity.getName(), tutor);
    }
}
