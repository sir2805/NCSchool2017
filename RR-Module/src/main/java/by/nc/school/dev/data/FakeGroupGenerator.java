package by.nc.school.dev.data;

import by.nc.school.dev.Role;
import by.nc.school.dev.dao.entities.GroupDaoEntity;
import by.nc.school.dev.dao.entities.UserDaoEntity;
import by.nc.school.dev.enitities.Group;
import by.nc.school.dev.enitities.Student;
import by.nc.school.dev.enitities.User;

import java.io.*;
import java.util.*;

public class FakeGroupGenerator extends AbstractFakeGenerator<Group>{

    public FakeGroupGenerator() {
        this.filepath = filedir + File.separator + "fakeGroups.txt";
    }

    @Override
    public void serialize() {

        List<User> users = new FakeUserGenerator().deserialize();
        assert users != null;

        try (FileOutputStream fos = new FileOutputStream(filepath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            int curId = 1;
            Map<Integer, User> tutors = new HashMap<>();
            for (User entity : users) {
                if (entity.getUserRole() == Role.TUTOR || entity.getUserRole() == Role.CURATOR) {
                    tutors.put(entity.get, entity);
                }
            }
            for (User entity : users) {
                if (entity.getUserRole() == Role.STUDENT) {
                    int studentId = entity.getId();
                    int groupNumber = entity.getGroupNumber();
                    int curatorId = tutors.get(groupNumber).getId();
                    Group group = new Group(curId++, studentId, groupNumber, curatorId);
                    oos.writeObject(group);
                }
            }
            oos.writeObject(null);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
