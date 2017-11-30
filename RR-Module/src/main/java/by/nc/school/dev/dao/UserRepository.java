package by.nc.school.dev.dao;

import by.nc.school.dev.dao.entity.UserDaoEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserDaoEntity, Long> {

    UserDaoEntity findUserByUsername(String username);
}
