package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {

    List<T> findAllByRole(int role);

    T findByFullname(String fullname);
}
