package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository <Subject, Long> {

}
