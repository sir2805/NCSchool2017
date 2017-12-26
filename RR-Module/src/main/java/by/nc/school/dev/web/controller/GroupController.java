package by.nc.school.dev.web.controller;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.service.AppStringsService;
import by.nc.school.dev.service.group.GroupService;
import by.nc.school.dev.service.PersonService;
import by.nc.school.dev.service.UserService;
import by.nc.school.dev.service.group.journal.GroupJournalService;
import by.nc.school.dev.service.group.workplan.GroupWorkPlanService;
import by.nc.school.dev.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(Pages.GROUP.PATH_ABSOLUTE)
public class GroupController {

    protected GroupService groupService;

    protected UserService userService;

    protected AppStringsService appStringsService;

    protected PersonService personService;

    protected GroupWorkPlanService groupWorkPlanService;

    protected GroupJournalService groupJournalService;

    @RequestMapping(method = RequestMethod.POST, params="init-group", path = Pages.GROUP.ADD_GROUP.PATH)
    public String initGroup(HttpSession session
                            ,@RequestParam("groupnumber") Integer groupNumber
                            ,@RequestParam("curator") String fullname) {
        //TODO resolve conflicts with same group number
        session.setAttribute(SessionAttributes.CURRENTLY_ADDING_GROUP, groupNumber);
        session.setAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS, new ArrayList<User>());
        Person selectedTutor = personService.getPersonByfullname(fullname);
        session.setAttribute(SessionAttributes.CURRENTLY_ADDING_CURATOR, selectedTutor);
        return "redirect:" + Pages.VIEWS.ADD_GROUP.PATH_ABSOLUTE;
    }
//
//    @RequestMapping(method = RequestMethod.POST, path = Pages.GROUP.ADD_CURATOR.PATH)
//    public String addCurator(HttpSession session
//            ,@RequestParam("curator") String fullname) {
//        User selectedTutor = userService.getUserByFullname(fullname);
//        selectedTutor.getPerson().setRole(Role.CURATOR);
//        userService.saveUser(selectedTutor);
//        session.setAttribute(SessionAttributes.CURRENTLY_ADDING_CURATOR, selectedTutor);
//        session.setAttribute(SessionAttributes.IS_CURATOR_ADDED, true);
//        return "redirect:" + Pages.VIEWS.ADD_GROUP.PATH_ABSOLUTE;
//    }


    @RequestMapping(method = RequestMethod.POST, params="add-student", path = Pages.GROUP.ADD_GROUP.PATH)
    public String addStudent(HttpSession session
                                 ,@RequestParam("username") String username
                                 ,@RequestParam("password") String password
                                 ,@RequestParam("fullname") String fullname) {
        User newStudent = userService.createUser(username, password, fullname, appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.STUDENT.KEY), null);

        if (session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS) == null) {
            session.setAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS, new ArrayList<>());
        }
        ((List<User>) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS)).add(newStudent);
        return "redirect:" + Pages.VIEWS.ADD_GROUP.PATH_ABSOLUTE;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, params="create-group",path = Pages.GROUP.ADD_GROUP.PATH)
    public String addGroup(HttpSession session) {
//        User curatorUser = userService.getUserByFullname(fullname);
//        curatorUser.getPerson().setRole(Role.CURATOR);
//        userService.saveUser(curatorUser);
        Group currentGroup =  groupService.createGroup((Integer) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_GROUP));
        List<User> studentUsers = (List<User>) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS);
        Curator curator = (Curator) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_CURATOR);

        curator.setGroup(currentGroup);
        currentGroup.setCurator(curator);

        for (User studentUser : studentUsers) {
            Student currentStudent =  (Student) studentUser.getPerson();
            currentStudent.setGroup(currentGroup);
            currentGroup.getStudents().add(currentStudent);
        }

//        Curator curator = personService.changeTutorToCurator(selectedTutor, currentGroup);


//        personService.savePerson(curator);
//        personService.saveNewlyAddedCurator(curator);

        groupService.saveGroup(currentGroup);

        GroupWorkPlan groupWorkPlan = groupWorkPlanService.initGroupWorkPlanFromGroup(currentGroup);

        groupJournalService.initGroupJournalFromGroupWorkPlan(groupWorkPlan);

        for (User studentUser : studentUsers) {
            userService.saveUser(studentUser);
        }

        personService.savePerson(curator);

        session.removeAttribute(SessionAttributes.CURRENTLY_ADDING_GROUP);
        session.removeAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS);
        session.removeAttribute(SessionAttributes.CURRENTLY_ADDING_CURATOR);
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }



    @Required
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Required
    public void setAppStringsService(AppStringsService appStringsService) {
        this.appStringsService = appStringsService;
    }

    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Required
    public void setGroupWorkPlanService(GroupWorkPlanService groupWorkPlanService) {
        this.groupWorkPlanService = groupWorkPlanService;
    }

    @Required
    public void setGroupJournalService(GroupJournalService groupJournalService) {
        this.groupJournalService = groupJournalService;
    }
}
