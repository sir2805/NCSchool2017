package by.nc.school.dev.web.controller;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.service.PersonService;
import by.nc.school.dev.service.SubjectService;
import by.nc.school.dev.service.group.GroupService;
import by.nc.school.dev.service.group.journal.GroupJournalService;
import by.nc.school.dev.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Pages.JOURNAL.PATH_ABSOLUTE)
public class JournalController {

    protected GroupService groupService;

    protected PersonService personService;

    protected SubjectService subjectService;

    protected GroupJournalService groupJournalService;

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.ADD_LESSON.PATH)
    public String addLesson(HttpSession session,
                            @RequestParam(name = "lesson_name") String lessonName) {
        GroupJournal groupJournal = (GroupJournal)session.getAttribute(SessionAttributes.CURRENT_GROUP_JOURNAL);
        Semester semester = groupJournal.getGroup().getCurrentSemester();
        Subject subject = (Subject) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        groupJournalService.addLesson(groupJournal, semester, subject, lessonName);
        return "redirect:" + Pages.VIEWS.JOURNAL.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.PUT_MARK.PATH)
    public String putMark(HttpSession session,
                          @RequestParam(name = "lesson") String lesson,
                          @RequestParam(name = "student") String studentFullname,
                          @RequestParam(name = "mark") Integer markValue) {
        GroupJournal groupJournal = (GroupJournal)session.getAttribute(SessionAttributes.CURRENT_GROUP_JOURNAL);
        Semester semester = groupJournal.getGroup().getCurrentSemester();
        Student student = (Student) personService.getPersonByfullname(studentFullname);
        Subject subject = (Subject) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        Mark mark = new Mark(markValue, false);
        groupJournalService.putMark(groupJournal, semester, student, subject, lesson, mark);
        return  "redirect:" + Pages.VIEWS.JOURNAL.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.SELECT_SUBJECT.PATH)
    public String selectSubject(HttpSession session,
                                @RequestParam(value = "subject") String subjectName) {
        session.setAttribute(SessionAttributes.CURRENT_SUBJECT, subjectService.getSubjectByName(subjectName));
        return "redirect:" + Pages.VIEWS.JOURNAL.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.SELECT_GROUP.PATH)
    public String selectGroup(HttpSession session,
                              @RequestParam(value = "group") String groupInfo) {
        session.setAttribute(SessionAttributes.CURRENT_GROUP, groupService.getGroupByGroupInfo(groupInfo));
        return "redirect:" + Pages.VIEWS.JOURNAL.PATH_ABSOLUTE;
    }

    @Required
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Required
    public void setGroupJournalService(GroupJournalService groupJournalService) {
        this.groupJournalService = groupJournalService;
    }

    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Required
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
