package by.nc.school.dev.web.controller;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.service.*;
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
@RequestMapping(Pages.WORKPLAN.PATH_ABSOLUTE)
public class WorkPlanController {

    protected GroupService groupService;

    protected SubjectService subjectService;

    protected PersonService personService;

    protected WorkPlanService workPlanService;

    protected TutorAndSubjectService tutorAndSubjectService;

    @RequestMapping(method = RequestMethod.POST, path = Pages.WORKPLAN.ADD_WORKPLAN.PATH, params="select-group")
    public String chooseGroup(HttpSession session,
                     @RequestParam(value = "group", required = false) String groupInfo) {

        session.setAttribute(SessionAttributes.CHOSEN_GROUP_INFO, groupInfo);
        session.setAttribute(SessionAttributes.CURRENTLY_ADDING_WORK_PLAN, new ArrayList<TutorAndSubject>());
        return "redirect:" + Pages.VIEWS.ADD_WORKPLAN.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.WORKPLAN.ADD_WORKPLAN.PATH, params="add-item")
    public String addWorkPlanItem(HttpSession session,
                                  @RequestParam(name = "tutorname") String tutorName,
                                  @RequestParam(name = "subjectname") String subjectName) {
        Tutor selectedTutor = (Tutor) personService.getPersonByfullname(tutorName);
        Subject selectedSubject = subjectService.getSubjectByName(subjectName);
        TutorAndSubject tutorAndSubject = new TutorAndSubject(selectedTutor, selectedSubject);
        ((List<TutorAndSubject>) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_WORK_PLAN)).add(tutorAndSubject);
        return "redirect:" + Pages.VIEWS.ADD_WORKPLAN.PATH_ABSOLUTE;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = Pages.WORKPLAN.ADD_WORKPLAN.PATH, params="add-plan")
    public String addWorkPlan(HttpSession session) {
        Group group = groupService.getGroup((String) session.getAttribute(SessionAttributes.CHOSEN_GROUP_INFO));
        List<TutorAndSubject> tutorAndSubjectList = (List<TutorAndSubject>) session.getAttribute(SessionAttributes.CURRENTLY_ADDING_WORK_PLAN);
        tutorAndSubjectService.saveAll(tutorAndSubjectList);
        workPlanService.saveSemesterWorkPlanForGroup(new SemesterWorkPlanForGroup(group, tutorAndSubjectList));
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }

    @Required
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Required
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Required
    public void setWorkPlanService(WorkPlanService workPlanService) {
        this.workPlanService = workPlanService;
    }

    @Required
    public void setTutorAndSubjectService(TutorAndSubjectService tutorAndSubjectService) {
        this.tutorAndSubjectService = tutorAndSubjectService;
    }
}
