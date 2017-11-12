package by.nc.school.dev.data;

import by.nc.school.dev.enitities.Subject;
import by.nc.school.dev.enitities.WorkPlan;

import java.io.*;
import java.util.List;
import java.util.Random;

public class FakeWorkPlanGenerator extends AbstractFakeGenerator <WorkPlan> {

    public FakeWorkPlanGenerator() {
        this.filepath = filedir + File.separator + "fakeWorkPlan.txt";
    }

    @Override
    public void serialize() {
        try (FileOutputStream fos = new FileOutputStream(filepath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            List<Subject> subjectDaoEntities = new FakeSubjectGenerator().deserialize();
            Random random = new Random();
            for (Subject subjectDaoEntity : subjectDaoEntities) {
                int subjectId = subjectDaoEntity.getId();
                int groupNumber = random.nextInt(4) + 1;
                oos.writeObject(new WorkPlan((int)System.currentTimeMillis(), groupNumber, subjectId));
            }
            oos.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
