//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.dao.DaoFactory;
//import by.nc.school.dev.dao.JournalDao;
//import by.nc.school.dev.dao.SubjectDao;
//import by.nc.school.dev.dao.UserDao;
//import by.nc.school.dev.dao.entities.JournalDaoEntity;
//import by.nc.school.dev.enitities.*;
//import by.nc.school.dev.services.GroupJournalService;
//import by.nc.school.dev.services.ServiceFactory;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class GroupJournalBuilder {
//
//    public GroupSemesterJournal build(int groupNumber) {
//        final DaoFactory daoFactory = new DaoFactory();
//        JournalDao journalDao = daoFactory.getJournalDao();
//        UserDao userDao = daoFactory.getUserDao();
//        SubjectDao subjectDao = daoFactory.getSubjectDao();
//        SubjectBuilder subjectBuilder = new SubjectBuilder();
//        GroupJournalService groupJournalService = new ServiceFactory().getGroupJournalService();
//
//        List<JournalDaoEntity> journalForGroup = journalDao.getJournalForGroup(groupNumber);
//        List<Subject> groupSubjects = groupJournalService.getSubjectsForGroup(groupNumber);
//        Map<Subject, GroupSubjectJournal> journal = new HashMap<>();
//
//        for (Subject subject : groupSubjects) {
//            journal.put(subject, new GroupSubjectJournal(subject));
//        }
//
//        for (JournalDaoEntity journalDaoEntity : journalForGroup) {
//            int studentId = journalDaoEntity.getStudentId();
//            int markValue = journalDaoEntity.getMark();
//            boolean markIsExamFlag = journalDaoEntity.isExam();
//            int subjectId = journalDaoEntity.getSubjectId();
//            Student student = (Student) new UserBuilder().build(userDao.get(studentId));
//            Mark mark = new Mark(markValue, markIsExamFlag);
//            Subject subject = subjectBuilder.build(subjectDao.get(subjectId));
//            if (journal.containsKey(subject)) {
//                groupJournalService.putMark(journal.get(subject), student, mark);
//            }
//            else throw new RuntimeException("subject isn't in the plan");
//        }
//
//        Group group = new GroupBuilder().build(groupNumber);
//        return new GroupSemesterJournal(group, journal);
//    }
//}
