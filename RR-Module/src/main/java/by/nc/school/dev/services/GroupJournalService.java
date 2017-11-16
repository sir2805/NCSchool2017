package by.nc.school.dev.services;

import by.nc.school.dev.builders.SubjectBuilder;
import by.nc.school.dev.dao.DaoFactory;
import by.nc.school.dev.dao.SubjectDao;
import by.nc.school.dev.dao.WorkPlanDao;
import by.nc.school.dev.dao.entities.WorkPlanDaoEntity;
import by.nc.school.dev.entities.*;

import java.util.ArrayList;
import java.util.List;

public class GroupJournalService {

    public List<Subject> getSubjectsForGroup(int groupNumber) {
        DaoFactory daoFactory = new DaoFactory();
        WorkPlanDao workPlanDao = daoFactory.getWorkPlanDao();
        List<WorkPlanDaoEntity> workPlanDaoEntities = workPlanDao.getWorkPlanForGroup(groupNumber);
        SubjectDao subjectDao = daoFactory.getSubjectDao();
        SubjectBuilder subjectBuilder = new SubjectBuilder();
        List<Subject> result = new ArrayList<>();
        for (WorkPlanDaoEntity workPlanDaoEntity : workPlanDaoEntities) {
            result.add(subjectBuilder.build(subjectDao.get(workPlanDaoEntity.getSubjectId())));
        }
        return result;
    }

    public GroupSubjectJournal getGroupSubjectJournal(GroupSemesterJournal groupSemesterJournal, Subject subject) {
        return groupSemesterJournal.getJournal().get(subject);
    }

    public void putMark(GroupSubjectJournal groupSubjectJournal, Student student, Mark mark) {
        if (!groupSubjectJournal.getMarksList().containsKey(student)) {
            groupSubjectJournal.getMarksList().put(student, new ArrayList<>());
        }
        groupSubjectJournal.getMarksList().get(student).add(mark);
    }
}
