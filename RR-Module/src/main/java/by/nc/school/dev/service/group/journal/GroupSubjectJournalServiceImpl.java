package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.GroupSubjectJournal;
import by.nc.school.dev.entity.ListOfMarks;
import by.nc.school.dev.entity.Student;
import by.nc.school.dev.repository.GroupSubjectJournalRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public class GroupSubjectJournalServiceImpl implements GroupSubjectJournalService {

    protected GroupSubjectJournalRepository groupSubjectJournalRepository;

    protected ListOfMarksService listOfMarksService;

    @Override
    public void saveGroupSubjectJournal(GroupSubjectJournal subjectJournal) {
        groupSubjectJournalRepository.save(subjectJournal);
    }

    @Override
    @Transactional
    public GroupSubjectJournal initGroupSubjectJournalFromGroup(Group group) {
        GroupSubjectJournal groupSubjectJournal = new GroupSubjectJournal();
        Map<Student, ListOfMarks> studentListOfMarksMap = new HashMap<>();

        for (Student student : group.getStudents()) {
            studentListOfMarksMap.put(student, listOfMarksService.initListOfMarks());
        }
        groupSubjectJournal.setMarksList(studentListOfMarksMap);
        groupSubjectJournalRepository.save(groupSubjectJournal);
        return groupSubjectJournal;
    }

    @Required
    public void setGroupSubjectJournalRepository(GroupSubjectJournalRepository groupSubjectJournalRepository) {
        this.groupSubjectJournalRepository = groupSubjectJournalRepository;
    }

    @Required
    public void setListOfMarksService(ListOfMarksService listOfMarksService) {
        this.listOfMarksService = listOfMarksService;
    }
}
