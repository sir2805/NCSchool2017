package by.nc.school.dev.dao;

import by.nc.school.dev.dao.entities.WorkPlanDaoEntity;
import by.nc.school.dev.data.FakeWorkPlanGenerator;
import by.nc.school.dev.entities.WorkPlan;

import java.util.List;
import java.util.stream.Collectors;

public class WorkPlanDao extends BaseDao<WorkPlan> {

    public WorkPlanDao() {
        entities = new FakeWorkPlanGenerator().deserialize();
    }

    public List<WorkPlan> getWorkPlanForGroup(int groupNumber) {
        return entities.stream().filter(entity -> entity.getGroupNumber() == groupNumber).collect(Collectors.toList());
    }

    public List<WorkPlan> getWorkPlan() {
        return entities;
    }

    @Override
    public WorkPlan create(WorkPlan entity) {
        return null;
    }

    @Override
    public void update(WorkPlan entity) {

    }

    @Override
    public void delete(WorkPlan entity) {

    }
}
