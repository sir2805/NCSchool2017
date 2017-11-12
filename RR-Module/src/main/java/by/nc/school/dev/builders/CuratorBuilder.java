//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.dao.entities.UserDaoEntity;
//import by.nc.school.dev.enitities.Curator;
//import by.nc.school.dev.enitities.Tutor;
//import by.nc.school.dev.enitities.User;
//
//public class CuratorBuilder extends AbstractUserBuilder {
//
//    public User build(UserDaoEntity userDaoEntity) {
//        return new Curator(userDaoEntity.getId(),
//                userDaoEntity.getStatus(),
//                userDaoEntity.getLogin(),
//                userDaoEntity.getPassword(),
//                userDaoEntity.getFullName(),
//                userDaoEntity.getGroupNumber());
//    }
//}
