package by.nc.school.dev.web.controller;

import by.nc.school.dev.entity.Curator;
import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Student;
import by.nc.school.dev.entity.User;
import by.nc.school.dev.service.AppStringsService;
import by.nc.school.dev.service.GroupService;
import by.nc.school.dev.service.UserService;
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

    @RequestMapping(method = RequestMethod.POST, path = Pages.GROUP.INIT_GROUP.PATH)
    public String initGroup(@RequestParam("groupnumber") Integer groupNumber, HttpSession session) {
        //TODO resolve conflicts with same group number
        session.setAttribute(SessionAttributes.CURRENTLY_ADDING_GROUP, groupService.createGroup(groupNumber));
        return "redirect:" + Pages.VIEWS.ADD_GROUP.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.GROUP.ADD_GROUP_MEMBER.PATH)
    public String addGroupMember(HttpSession session
                                 ,@RequestParam("username") String username
                                 ,@RequestParam("password") String password
                                 ,@RequestParam("fullname") String fullname) {
        if (Boolean.TRUE.equals(session.getAttribute(SessionAttributes.IS_CURATOR_ADDED))) {
            User newStudent = userService.createUser(username, password, fullname, appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.STUDENT.KEY), null);
            ((List<User>) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS)).add(newStudent);
        } else {
            User curator = userService.createUser(username, password, fullname, appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.CURATOR.KEY), null);
            session.setAttribute(SessionAttributes.CURRENTLY_ADDING_CURATOR, curator);
            session.setAttribute(SessionAttributes.IS_CURATOR_ADDED, true);
            session.setAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS, new ArrayList<User>());
        }

        return "redirect:" + Pages.VIEWS.ADD_GROUP.PATH_ABSOLUTE;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = Pages.GROUP.ADD_GROUP.PATH)
    public String addGroup(HttpSession session) {
        Group currentGroup = (Group) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_GROUP);
        List<User> studentUsers = (List<User>) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS);
        User curatorUser = (User) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_CURATOR);
        Curator curator = (Curator) curatorUser.getPerson();
        curator.setGroup(currentGroup);
        currentGroup.setCurator(curator);
        userService.addUser(curatorUser);
        for (User studentUser : studentUsers) {
            Student currentStudent =  (Student) studentUser.getPerson();
            currentStudent.setGroup(currentGroup);
            groupService.addStudent(currentGroup, currentStudent);
            userService.addUser(studentUser);
        }
        groupService.addGroup(currentGroup);
        session.removeAttribute(SessionAttributes.CURRENTLY_ADDING_GROUP);
        session.removeAttribute(SessionAttributes.IS_CURATOR_ADDED);
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
}
