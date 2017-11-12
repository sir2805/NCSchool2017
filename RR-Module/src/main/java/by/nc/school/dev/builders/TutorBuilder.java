//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.dao.entities.UserDaoEntity;
//import by.nc.school.dev.enitities.Tutor;
//import by.nc.school.dev.enitities.User;
//
//public class TutorBuilder extends AbstractUserBuilder {
//
//    public User build(UserDaoEntity userDaoEntity) {
//        return new Tutor(userDaoEntity.getId(),
//                userDaoEntity.getStatus(),
//                userDaoEntity.getLogin(),
//                userDaoEntity.getPassword(),
//                userDaoEntity.getFullName());
//    }
//}
