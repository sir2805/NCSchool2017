package by.nc.school.dev.dao;

import by.nc.school.dev.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
