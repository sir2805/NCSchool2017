//package by.nc.school.dev.builders;
//
//import by.nc.school.dev.dao.entities.UserDaoEntity;
//import by.nc.school.dev.enitities.Student;
//import by.nc.school.dev.enitities.User;
//
//public class StudentBuilder extends AbstractUserBuilder {
//
//    public User build(UserDaoEntity userDaoEntity) {
//        return new Student(userDaoEntity.getId(),
//                userDaoEntity.getStatus(),
//                userDaoEntity.getLogin(),
//                userDaoEntity.getPassword(),
//                userDaoEntity.getFullName(),
//                userDaoEntity.getGroupNumber());
//    }
//}
