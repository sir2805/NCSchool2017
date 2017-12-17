package by.nc.school.dev.web.controller;

import by.nc.school.dev.service.SubjectService;
import by.nc.school.dev.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(Pages.SUBJECT.PATH_ABSOLUTE)
public class SubjectController {

    protected SubjectService subjectService;

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = Pages.SUBJECT.ADD_SUBJECT.ADD.PATH)
    public String initGroup(@RequestParam("subject_name") String subjectName) {
        subjectService.addSubject(subjectName);
        return "redirect:" + Pages.VIEWS.ADD_SUBJECT.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.SUBJECT.ADD_SUBJECT.FINISH.PATH)
    public String finish() {
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }

    @Required
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
}
