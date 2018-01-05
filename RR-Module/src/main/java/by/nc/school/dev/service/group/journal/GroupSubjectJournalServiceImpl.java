package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupSubjectJournalRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupSubjectJournalServiceImpl implements GroupSubjectJournalService {

    protected GroupSubjectJournalRepository groupSubjectJournalRepository;

    protected ListOfMarksService listOfMarksService;

    @Override
    public void saveGroupSubjectJournal(GroupSubjectJournal subjectJournal) {
        groupSubjectJournalRepository.save(subjectJournal);
    }

    @Override
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

    @Override
    public void putMark(GroupSubjectJournal groupSubjectJournal, Student student, String lessonName, Mark mark) {
        listOfMarksService.putMark(groupSubjectJournal.getMarksList().get(student), lessonName, mark);
//        List<String> lessonNames = subjectJournal.getLessonNames();
//        if (!lessonNames.contains(lessonName)) {
//            lessonNames.add(lessonName);
//        }
    }

    @Override
    public void addLesson(GroupSubjectJournal groupSubjectJournal, String lessonName) {
        Set<String> lessonNames = groupSubjectJournal.getLessonNames();
        lessonNames.add(lessonName);
        groupSubjectJournal.setLessonNames(lessonNames);
        groupSubjectJournalRepository.save(groupSubjectJournal);
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
