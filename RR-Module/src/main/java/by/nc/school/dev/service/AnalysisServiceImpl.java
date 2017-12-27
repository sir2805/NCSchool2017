package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupJournalRepository;
import by.nc.school.dev.repository.GroupSemesterJournalRepository;
import by.nc.school.dev.repository.GroupSubjectJournalRepository;
import by.nc.school.dev.utils.Constants;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisServiceImpl implements AnalysisService {

    protected GroupSemesterJournalRepository groupSemesterJournalRepository;

    @Override
    public Map<Student, List<Subject>> findAllStudentsWithBadAverageMark() {

        Map<Student, List<Subject>> insufficientStudents = new HashMap<>();

        List<GroupSemesterJournal> groupSemesterJournals = groupSemesterJournalRepository.findAll();
        for (GroupSemesterJournal groupSemesterJournal : groupSemesterJournals) {
            for (Subject subject : groupSemesterJournal.getSemesterJournal().keySet()) {
                GroupSubjectJournal groupSubjectJournal = groupSemesterJournal.getSemesterJournal().get(subject);
                Map<Student, ListOfMarks> marksMap = groupSubjectJournal.getMarksList();
                for (Student student : marksMap.keySet()) {
                    double totalMark = 0.0;
                    int marksAmount = 0;
                    for (Mark mark : marksMap.get(student).getMarks().values()) {
                        totalMark += mark.getMark();
                        marksAmount++;
                    }
                    double averageMark = totalMark / marksAmount;
                    if (averageMark < Constants.INSUFFICIENCY_MARGIN) {
                        insufficientStudents.computeIfAbsent(student, k -> new ArrayList<>());
                        insufficientStudents.get(student).add(subject);
                    }
                }
            }
        }
        return insufficientStudents;
    }

    @Required
    public void setGroupSemesterJournalRepository(GroupSemesterJournalRepository groupSemesterJournalRepository) {
        this.groupSemesterJournalRepository = groupSemesterJournalRepository;
    }
}
