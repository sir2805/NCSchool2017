package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupJournalRepository;
import by.nc.school.dev.repository.GroupSemesterJournalRepository;
import by.nc.school.dev.repository.GroupSubjectJournalRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GroupSemesterJournalServiceImpl implements GroupSemesterJournalService {

    protected GroupJournalRepository groupJournalRepository;

    protected GroupSemesterJournalRepository groupSemesterJournalRepository;

    protected GroupSubjectJournalRepository groupSubjectJournalRepository;

    @Override
    public GroupSemesterJournal getSemesterJournalForGroup(Group group) {
        return groupJournalRepository.findGroupJournalByGroup(group).getGroupJournal().get(group.getCurrentSemester());
    }

    @Transactional
    @Override
    public void putMark(GroupSemesterJournal semesterJournal, Student student, Subject subject, String lessonName, Mark mark) {
        GroupSubjectJournal groupSubjectJournal = semesterJournal.getSemesterJournal().get(subject);
        List<String> lessonNames = groupSubjectJournal.getLessonNames();
        if (!lessonNames.contains(lessonName)) {
            lessonNames.add(lessonName);
        }
        groupSubjectJournal.getMarksList().get(student).getMarks().put(lessonName, mark);
        groupSubjectJournalRepository.save(groupSubjectJournal);
    }

    @Required
    public void setGroupJournalRepository(GroupJournalRepository groupJournalRepository) {
        this.groupJournalRepository = groupJournalRepository;
    }

    @Required
    public void setGroupSemesterJournalRepository(GroupSemesterJournalRepository groupSemesterJournalRepository) {
        this.groupSemesterJournalRepository = groupSemesterJournalRepository;
    }

    @Required
    public void setGroupSubjectJournalRepository(GroupSubjectJournalRepository groupSubjectJournalRepository) {
        this.groupSubjectJournalRepository = groupSubjectJournalRepository;
    }
}
