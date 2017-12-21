package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
    Semester findBySemesterNumber(int semesterNumber);
}
