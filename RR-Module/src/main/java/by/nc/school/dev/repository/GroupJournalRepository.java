package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupJournal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJournalRepository extends JpaRepository<GroupJournal, Long> {

    GroupJournal findGroupJournalByGroup(Group group);
}
