//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.dao.DaoFactory;
//import by.nc.school.dev.dao.SubjectDao;
//import by.nc.school.dev.dao.WorkPlanDao;
//import by.nc.school.dev.dao.entities.WorkPlanDaoEntity;
//import by.nc.school.dev.enitities.Subject;
//import by.nc.school.dev.enitities.WorkPlan;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class WorkPlanBuilder {
//
//    public WorkPlan build(List<WorkPlanDaoEntity> workPlanDaoEntities) {
//        Map<Integer, List<Subject>> plan = new HashMap<>();
//        DaoFactory daoFactory = new DaoFactory();
//        WorkPlanDao workPlanDao = daoFactory.getWorkPlanDao();
//        SubjectDao subjectDao = daoFactory.getSubjectDao();
//        SubjectBuilder subjectBuilder = new SubjectBuilder();
//        for (WorkPlanDaoEntity workPlanDaoEntity : workPlanDaoEntities) {
//            int groupNumber = workPlanDaoEntity.getGroupNumber();
//            int subjectId = workPlanDaoEntity.getSubjectId();
//            if (!plan.containsKey(groupNumber)) {
//                plan.put(groupNumber, new ArrayList<>());
//            }
//            plan.get(groupNumber).add(subjectBuilder.build(subjectDao.get(workPlanDaoEntity.getSubjectId())));
//        }
//        return new WorkPlan(plan);
//    }
//}
