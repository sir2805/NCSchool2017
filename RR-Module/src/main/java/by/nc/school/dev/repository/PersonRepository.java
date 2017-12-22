package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {

    List<T> findAllByRole(int role);

    T findByFullname(String fullname);

    @Query(value = "insert into curator (id, group_id) VALUES (?1, ?2)", nativeQuery = true)
    void addCuratorForExistingTutor(Long tutorId, Long groupId);
}
