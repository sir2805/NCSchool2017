package by.nc.school.dev.dao;

import by.nc.school.dev.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);
}
