package by.nc.school.dev.dao;

import by.nc.school.dev.dao.entities.JournalDaoEntity;
import by.nc.school.dev.data.TestJournalDb;
import by.nc.school.dev.entities.GroupJournal;

import java.util.stream.Collectors;

public class JournalDao extends BaseDao<GroupJournal> {

    private TestJournalDb testJournalDb;

    public JournalDao() {
        testJournalDb = new TestJournalDb();
        entities = testJournalDb.deserialize();
    }

    public GroupJournal getJournalForGroup(int groupNumber) {
//        List<JournalDaoEntity> result = new ArrayList<>();
        UserDao userDao = new DaoFactory().getUserDao();
//        for (JournalDaoEntity entity : entities) {
//            if (userDao.get(entity.getStudentId()).getGroupNumber() == groupNumber) {
//                result.add(entity);
//            }
//        }
        return entities.stream().filter(entity -> userDao.get(entity.getStudentId()).getGroupNumber() == groupNumber)
                .collect(Collectors.toList());
    }

    @Override
    public GroupJournal create(GroupJournal entity) {
        entities.add(entity);
        testJournalDb.serialize(entities);
        return entity;
    }

    @Override
    public void update(GroupJournal entity) {

    }

    @Override
    public void delete(GroupJournal entity) {

    }
}
