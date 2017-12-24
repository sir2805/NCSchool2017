package by.nc.school.dev.service.group;

import by.nc.school.dev.repository.GroupRepository;
import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Student;
import by.nc.school.dev.service.SemesterService;
import org.springframework.beans.factory.annotation.Required;

public class GroupServiceImpl implements GroupService {

    protected GroupRepository groupRepository;

    protected SemesterService semesterService;

    @Override
    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Group getGroup(int groupNumber) {
        return groupRepository.findGroupByGroupNumber(groupNumber);
    }

    @Override
    public Group getGroup(String groupInfo) {
        String[] groupInfoArr = groupInfo.split(", ");
        Integer semesterNumber = Integer.valueOf(groupInfoArr[0]);
        Integer groupNumber = Integer.valueOf(groupInfoArr[1]);
        return groupRepository.findGroupByGroupNumberAndCurrentSemester_SemesterNumber(groupNumber, semesterNumber);
    }

    @Override
    public Group createGroup(int groupNumber) {
        return new Group(groupNumber, semesterService.getFirstSemester());
    }

    @Override
    public void addStudent(Group group, Student student) {
        group.getStudents().add(student);
    }

    @Required
    public void setSemesterService(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @Required
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
