package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;

import by.nc.school.dev.repository.GroupSemesterJournalRepository;
import by.nc.school.dev.utils.Constants;
import org.springframework.beans.factory.annotation.Required;

import java.util.*;

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

    @Override
    public Set<Student> findAllStudentsWithExcellentMarks() {
        Map<Student, Boolean> studentsMap = new HashMap<>();
        List<GroupSemesterJournal> groupSemesterJournals = groupSemesterJournalRepository.findAll();
        for (GroupSemesterJournal groupSemesterJournal : groupSemesterJournals) {
            for (Subject subject : groupSemesterJournal.getSemesterJournal().keySet()) {
                GroupSubjectJournal groupSubjectJournal = groupSemesterJournal.getSemesterJournal().get(subject);
                Map<Student, ListOfMarks> marksMap = groupSubjectJournal.getMarksList();
                for (Student student : marksMap.keySet()) {
                    int marksCount = 0;
                    for (Mark mark : marksMap.get(student).getMarks().values()) {
                        if (mark.getMark() >= Constants.SUFFICIENCY_MARGIN) {
                            marksCount++;
                        }
                    }
                    if (marksCount != 0) {
                        if (!studentsMap.containsKey(student) && marksCount == marksMap.get(student).getMarks().size()) {
                            studentsMap.putIfAbsent(student, true);
                        } else if (studentsMap.containsKey(student)) {
                            studentsMap.put(student, false);
                        }
                    }
                }
            }
        }
        Set<Student> goodStudents = new HashSet<>();
        for (Student student : studentsMap.keySet()) {
            if (studentsMap.get(student)) {
                goodStudents.add(student);
            }
        }
        return goodStudents;
    }

    @Required
    public void setGroupSemesterJournalRepository(GroupSemesterJournalRepository groupSemesterJournalRepository) {
        this.groupSemesterJournalRepository = groupSemesterJournalRepository;
    }
}
