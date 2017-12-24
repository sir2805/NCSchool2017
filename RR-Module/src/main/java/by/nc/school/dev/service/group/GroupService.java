package by.nc.school.dev.service.group;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Student;

public interface GroupService {

    void saveGroup(Group group);

    Group getGroup(int groupNumber);

    Group getGroup(String groupInfo);

    Group createGroup(int groupNumber);

    void addStudent(Group group, Student student);
}
