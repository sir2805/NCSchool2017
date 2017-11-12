//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.dao.DaoFactory;
//import by.nc.school.dev.dao.entities.SubjectDaoEntity;
//import by.nc.school.dev.dao.entities.UserDaoEntity;
//import by.nc.school.dev.enitities.Subject;
//import by.nc.school.dev.enitities.Tutor;
//
//public class SubjectBuilder {
//    public Subject build(SubjectDaoEntity subjectDaoEntity) {
//        UserDaoEntity tutorDaoEntity = new DaoFactory().getUserDao().get(subjectDaoEntity.getTutorId());
//        Tutor tutor = (Tutor) new TutorBuilder().build(tutorDaoEntity);
//        return new Subject(subjectDaoEntity.getId(), subjectDaoEntity.getName(), tutor);
//    }
//
//    public Subject build(String subjectName) {
//        SubjectDaoEntity subjectDaoEntity = new DaoFactory().getSubjectDao().getSubjectBySubjectName(subjectName);
//        UserDaoEntity tutorDaoEntity = new DaoFactory().getUserDao().get(subjectDaoEntity.getTutorId());
//        Tutor tutor = (Tutor) new TutorBuilder().build(tutorDaoEntity);
//        return new Subject(subjectDaoEntity.getId(), subjectDaoEntity.getName(), tutor);
//    }
//}
