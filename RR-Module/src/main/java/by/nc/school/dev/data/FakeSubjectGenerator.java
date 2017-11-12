package by.nc.school.dev.data;

import by.nc.school.dev.dao.UserDao;
import by.nc.school.dev.enitities.Subject;
import by.nc.school.dev.enitities.Tutor;
import by.nc.school.dev.enitities.User;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FakeSubjectGenerator extends AbstractFakeGenerator<Subject> {

    private final String[] subjectNames = {
            "Remedial Math",
            "Fundamental Math or Basic Math",
            "Mathematics",
            "Pre-Algebra",
            "Introduction to Algebra",
            "Algebra",
            "Geometry",
            "Trigonometry",
            "Statistics"};

    public FakeSubjectGenerator() {
        this.filepath = filedir + File.separator + "fakeSubjects.txt";
    }

    @Override
    public void serialize() {
        try (FileOutputStream fos = new FileOutputStream(filepath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            int id = 1;
            List<User> tutors = new UserDao().getTutors();
            int tutorsPos = 0;
            for (String subjectName : subjectNames) {
                if (tutorsPos == tutors.size()) {
                    tutorsPos = 0;
                }
                Subject subject = new Subject(id++, subjectName, (Tutor)tutors.get(tutorsPos++));
                oos.writeObject(subject);
            }
            oos.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
