package by.nc.school.dev.dao;

import by.nc.school.dev.dao.entities.SubjectDaoEntity;
import by.nc.school.dev.data.FakeSubjectGenerator;
import by.nc.school.dev.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectDao extends BaseDao<Subject> {

    public SubjectDao() {
        this.entities = new FakeSubjectGenerator().deserialize();
    }

    public List<Subject> getAllSubjects() {
        return entities;
    }

    public List<Subject> getSubjectsByTutorId(int tutorId) {
        List<Subject>result = new ArrayList<>();
        for (Subject entity : entities) {
            if (entity.getTutorId() == tutorId) {
                result.add(entity);
            }
        }
        return result;
    }

    public Subject getSubjectBySubjectName(String subjectName) {
        for (SubjectDaoEntity entity : entities) {
            if (entity.getName().equals(subjectName)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public Subject create(Subject entity) {
        return null;
    }

    @Override
    public void update(Subject entity) {

    }

    @Override
    public void delete(Subject entity) {

    }
}
