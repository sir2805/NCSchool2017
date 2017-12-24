package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupWorkPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupWorkPlanRepository extends JpaRepository<GroupWorkPlan, Long> {

    GroupWorkPlan findByGroup(Group group);
}
