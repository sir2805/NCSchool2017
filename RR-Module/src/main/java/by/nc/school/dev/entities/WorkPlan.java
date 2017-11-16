package by.nc.school.dev.entities;

import by.nc.school.dev.utils.Pair;

import java.util.List;
import java.util.Map;

public class WorkPlan extends BaseEntity {

    private Map<Integer, List<Pair<Tutor, Subject>>> plan; //groupNumber and List<Subject>
    private Semester semester;

    public WorkPlan(int id, Map<Integer, List<Pair<Tutor, Subject>>> plan, Semester semester) {
        super(id);
        this.plan = plan;
        this.semester = semester;
    }

    public Map<Integer, List<Pair<Tutor, Subject>>> getPlan() {
        return plan;
    }

    public void setPlan(Map<Integer, List<Pair<Tutor, Subject>>> plan) {
        this.plan = plan;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "WorkPlan{" +
                "plan=" + plan +
                ", semester=" + semester +
                '}';
    }
}
