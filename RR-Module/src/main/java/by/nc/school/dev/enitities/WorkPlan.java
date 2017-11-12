package by.nc.school.dev.enitities;

import java.util.List;
import java.util.Map;

public class WorkPlan extends BaseEntity {

    private Map<Integer, List<Subject>> plan;
    private Semester semester;

    public WorkPlan(int id, Map<Integer, List<Subject>> plan, Semester semester) {
        super(id);
        this.plan = plan;
        this.semester = semester;
    }

    public Semester getSemester() {
        return semester;
    }

    public Map<Integer, List<Subject>> getPlan() {
        return plan;
    }

    @Override
    public String toString() {
        return "WorkPlan{" +
                "plan=" + plan +
                ", semester=" + semester +
                '}';
    }
}
