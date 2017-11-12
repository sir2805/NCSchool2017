//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.Role;
//import by.nc.school.dev.dao.entities.UserDaoEntity;
//import by.nc.school.dev.enitities.User;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class UserBuilder extends AbstractUserBuilder {
//
//    public User build(UserDaoEntity userDaoEntity) {
//        if (userDaoEntity == null) {
//            return null;
//        }
//        int status = userDaoEntity.getStatus();
//        if (status > 4 || status <= 0) {
//            throw new UnsupportedOperationException("Invalid status");
//        } else {
//            return userBuilders.get(status).build(userDaoEntity);
//        }
//    }
//
//    private Map<Integer, AbstractUserBuilder> userBuilders = new HashMap<>();
//
//    public UserBuilder() {
//        userBuilders.put(Role.STUDENT, new StudentBuilder());
//        userBuilders.put(Role.TUTOR, new TutorBuilder());
//        userBuilders.put(Role.CURATOR, new CuratorBuilder());
//        userBuilders.put(Role.DEAN, new DeanBuilder());
//    }
//}
