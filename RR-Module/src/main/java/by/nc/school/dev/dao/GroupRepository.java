package by.nc.school.dev.dao;

import by.nc.school.dev.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findGroupByGroupNumber(int groupNumber);
}
