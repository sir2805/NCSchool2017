package by.nc.school.dev.web.provider;

import by.nc.school.dev.Role;
import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.GroupJournalRepository;
import by.nc.school.dev.repository.GroupRepository;
import by.nc.school.dev.service.group.workplan.GroupSemesterWorkPlanService;
import by.nc.school.dev.web.controller.SessionAttributes;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;

public class JournalModelProvider implements ModelProvider {

    protected GroupRepository groupRepository;

    protected GroupJournalRepository groupJournalRepository;

    protected GroupSemesterWorkPlanService groupSemesterWorkPlanService;

    private JournalModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        Group currentGroup = (Group) session.getAttribute(SessionAttributes.CURRENT_GROUP);
        if (currentGroup == null) {
            Person currentPerson = (Person) session.getAttribute(SessionAttributes.CURRENT_PERSON);
            if (currentPerson.getRole() == Role.STUDENT) {
                currentGroup = ((Student)currentPerson).getGroup();
            } else {
                fillModel(model, new HashSet<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                return;
            }
        }
        GroupJournal groupJournal = (GroupJournal) session.getAttribute(SessionAttributes.CURRENT_GROUP_JOURNAL);
        //TODO ask what is best: save groupJournal in session or load it from db
        if (groupJournal == null) {
            groupJournal = groupJournalRepository.findGroupJournalByGroup(currentGroup);
            session.setAttribute(SessionAttributes.CURRENT_GROUP_JOURNAL, groupJournal);
        }
        Set<Subject> subjects = groupSemesterWorkPlanService.getAllSubjects(groupJournal.getGroupWorkPlan().getPlan().get(currentGroup.getCurrentSemester()));
        Subject currentSubject = (Subject) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        if (currentSubject == null) {
            fillModel(model, subjects, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            return;
        }
        model.addAttribute("students", currentGroup.getStudents());
        Hibernate.initialize(groupJournal.getGroupJournalMap());
        GroupSubjectJournal groupSubjectJournal = groupJournal.getGroupJournalMap().get(currentGroup.getCurrentSemester()).getSemesterJournal().get(currentSubject);
        List<String> lessons = groupSubjectJournal.getLessonNames();
        model.addAttribute("lessons", lessons);
        Map<Student, ListOfMarks> marks = groupSubjectJournal.getMarksList();
        List<List<String>> marksTable = new ArrayList<>();

        for (Student student : marks.keySet()) {
            List<String> marksForStudent = new ArrayList<>();
            for (String lesson : lessons) {
                Mark mark = marks.get(student).getMarks().get(lesson);
                if (mark == null) {
                    marksForStudent.add(" ");
                }
                else {
                    marksForStudent.add(mark.toString());
                }
            }
            marksTable.add(marksForStudent);
        }
        fillModel(model, subjects, currentGroup.getStudents(), lessons, marksTable);
    }

    protected void fillModel(Model model, Set<Subject> subjects, List<Student> students, List<String> lessons, List<List<String>> marksTable) {
        model.addAttribute("groups", groupRepository.findAll());
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
}
