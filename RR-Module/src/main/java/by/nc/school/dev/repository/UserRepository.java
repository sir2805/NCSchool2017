package by.nc.school.dev.repository;

import by.nc.school.dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserByPersonFullname(String fullname);

    List<User> findAllByPersonRole(int role);
}
