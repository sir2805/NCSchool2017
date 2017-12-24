package by.nc.school.dev.web.controller;

import by.nc.school.dev.Role;
import by.nc.school.dev.entity.*;
import by.nc.school.dev.service.group.GroupService;
import by.nc.school.dev.service.UserService;

import by.nc.school.dev.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Pages.USER.PATH_ABSOLUTE)
public class UserController {

    protected UserService userService;

    protected GroupService groupService;

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.LOGIN.PATH)
    public String login(HttpSession session
            ,@RequestParam("username") String username
            ,@RequestParam("password") String password) {
        User currentUser = userService.login(username, password);
        boolean isLoggedIn = currentUser != null;
        session.setAttribute(SessionAttributes.IS_LOGGED_IN, isLoggedIn);
        if (isLoggedIn) {
            Person currentPerson = currentUser.getPerson();
            session.setAttribute(SessionAttributes.CURRENT_PERSON, currentPerson);
            if (currentPerson.getRole() == Role.STUDENT) {
                return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
            } else {
                //TODO refactor using Spring convertor and UserViewModel
                return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
            }
        } else {
            return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.LOGOUT.PATH)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + Pages.VIEWS.LOGIN.PATH_ABSOLUTE;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.NEW_USER.PATH)
    public String addUser(@RequestParam("username") String username
            ,@RequestParam("password") String password
            ,@RequestParam("fullname") String fullname
            ,@RequestParam("role") String role
            ,@RequestParam(value = "group", required = false) String groupInfo) {
        Group group = null;
        if (groupInfo != null) {
            group = groupService.getGroup(groupInfo);
        }
        userService.saveUser(username, password, fullname, role, group);
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }

//    @Transactional
//    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.ADD_STUDENT.PATH)
//    public String addGroupMember(@RequestParam("username") String username
//            ,@RequestParam("password") String password
//            ,@RequestParam("fullname") String fullname
//            ,@RequestParam("role") String role
//            ,@RequestParam("group") Group group) {
//        userService.saveUser(username, password, fullname, role, group);
//        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
//    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Required
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
