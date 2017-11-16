package by.nc.school.dev.services;

import by.nc.school.dev.entities.Group;
import by.nc.school.dev.builders.GroupBuilder;


public class GroupService {

    public Group getGroupByGroupNumber(int groupNumber) {
        return new GroupBuilder().build(groupNumber);
    }
}
