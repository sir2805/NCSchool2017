package by.nc.school.dev.web.provider;

import by.nc.school.dev.Role;
import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupJournalRepository;
import by.nc.school.dev.repository.GroupRepository;
import by.nc.school.dev.service.group.workplan.GroupSemesterWorkPlanService;
import by.nc.school.dev.service.group.workplan.GroupWorkPlanService;
import by.nc.school.dev.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

public class JournalModelProvider implements ModelProvider {

    protected GroupRepository groupRepository;

    protected GroupJournalRepository groupJournalRepository;

    protected GroupSemesterWorkPlanService groupSemesterWorkPlanService;

    protected GroupWorkPlanService groupWorkPlanService;

    private JournalModelProvider() {}

    @Override
    @Transactional
    public void fillModel(Model model, HttpSession session) {
        Group currentGroup = (Group) session.getAttribute(SessionAttributes.CURRENT_GROUP);
        Person currentPerson = (Person) session.getAttribute(SessionAttributes.CURRENT_PERSON);
        if (currentGroup == null) {
            if (currentPerson.getRole() == Role.STUDENT) {
                currentGroup = ((Student)currentPerson).getGroup();
            } else {
                fillModel(model, new HashSet<>(), new ArrayList<>(), new HashSet<>(), new ArrayList<>());
                return;
            }
        }
        GroupJournal groupJournal = (GroupJournal) session.getAttribute(SessionAttributes.CURRENT_GROUP_JOURNAL);
        if (groupJournal == null) {
            groupJournal = groupJournalRepository.findGroupJournalByGroup(currentGroup);
            session.setAttribute(SessionAttributes.CURRENT_GROUP_JOURNAL, groupJournal);
        }
        Set<Subject> subjects;
        if (currentPerson.getRole() == Role.CURATOR) {
            Curator curator = (Curator) currentPerson;
            subjects = groupSemesterWorkPlanService.getAllSubjectsForTutor(curator, groupJournal.getGroupWorkPlan().getPlan().get(currentGroup.getCurrentSemester()));
        } else {
            subjects = groupSemesterWorkPlanService.getAllSubjects(groupJournal.getGroupWorkPlan().getPlan().get(currentGroup.getCurrentSemester()));
        }
        Subject currentSubject = (Subject) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        if (currentSubject == null) {
            fillModel(model, subjects, new ArrayList<>(), new HashSet<>(), new ArrayList<>());
            return;
        }
        GroupSubjectJournal groupSubjectJournal = groupJournal.getGroupJournalMap().get(currentGroup.getCurrentSemester()).getSemesterJournal().get(currentSubject);
        Set<String> lessons = groupSubjectJournal.getLessonNames();
        Map<Student, ListOfMarks> marks = groupSubjectJournal.getMarksList();
        List<List<String>> marksTable = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        for (Student student : marks.keySet()) {
            List<String> marksForStudent = new ArrayList<>();
            students.add(student);
            double totalMark = 0.0;
            int marksAmount = 0;
            for (String lesson : lessons) {
                Mark mark = marks.get(student).getMarks().get(lesson);
                if (mark == null) {
                    marksForStudent.add(" ");
                }
                else {
                    totalMark += mark.getMark();
                    marksAmount++;
                    marksForStudent.add(mark.toString());
                }
            }
            if (marksAmount == 0) {
                marksForStudent.add(" ");
            } else {
                marksForStudent.add(String.valueOf(totalMark / marksAmount));
            }
            marksTable.add(marksForStudent);
        }
        fillModel(model, subjects, students, lessons, marksTable);
    }

    protected void fillModel(Model model, Set<Subject> subjects, List<Student> students, Set<String> lessons, List<List<String>> marksTable) {
        List<Group> groups = groupRepository.findAll().stream().filter(group -> groupWorkPlanService.isWorkPlanForGroupExists(group)).collect(Collectors.toList());
        model.addAttribute("groups", groups);
        model.addAttribute("subjects", subjects);
        model.addAttribute("students", students);
        model.addAttribute("lessons", lessons);
        model.addAttribute("lessonsAndMarks", marksTable);
    }

    @Required
    public void setGroupJournalRepository(GroupJournalRepository groupJournalRepository) {
        this.groupJournalRepository = groupJournalRepository;
    }

    @Required
    public void setGroupSemesterWorkPlanService(GroupSemesterWorkPlanService groupSemesterWorkPlanService) {
        this.groupSemesterWorkPlanService = groupSemesterWorkPlanService;
    }

    @Required
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Required
    public void setGroupWorkPlanService(GroupWorkPlanService groupWorkPlanService) {
        this.groupWorkPlanService = groupWorkPlanService;
    }
}
