package by.nc.school.dev.dao;

import by.nc.school.dev.dao.entities.GroupDaoEntity;
import by.nc.school.dev.data.FakeGroupGenerator;
import by.nc.school.dev.entities.Group;

public class GroupDao extends BaseDao<Group> {

    public GroupDao() {
        this.entities = new FakeGroupGenerator().deserialize();
    }

    public Group getGroupByGroupNumber(int groupNumber) {
//        List<GroupDaoEntity> result = new ArrayList<>();
//        for (GroupDaoEntity entity : entities) {
//            if (entity.getGroupNumber() == groupNumber) {
//                result.add(entity);
//            }
//        }
        return null;
    }

    public Group create(Group entity) {
        return null;
    }

    public void update(Group entity) {

    }

    public void delete(Group entity) {

    }
}
