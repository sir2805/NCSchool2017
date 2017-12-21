package by.nc.school.dev.web.controller;

import by.nc.school.dev.web.Pages;
import by.nc.school.dev.web.provider.ModelProvider;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(Pages.VIEWS.PATH_ABSOLUTE)
public class ViewController {

    protected Map<String, ModelProvider> modelProviders;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "redirect:" + Pages.VIEWS.LOGIN.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.HOME.PATH)
    public String getHomePage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.HOME.VIEW);
        return Pages.VIEWS.HOME.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.GROUP.PATH)
    public String getGroupPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.GROUP.VIEW);
        return Pages.VIEWS.GROUP.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.ADD_GROUP.PATH)
    public String getAddGroupPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.ADD_GROUP.VIEW);
        return Pages.VIEWS.ADD_GROUP.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.ADD_USER.PATH)
    public String getAddUserPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.ADD_USER.VIEW);
        return Pages.VIEWS.ADD_USER.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.ADD_SUBJECT.PATH)
    public String getAddSubjectPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.HOME.VIEW);
        return Pages.VIEWS.ADD_SUBJECT.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.ADD_WORKPLAN.PATH)
    public String getAddWorkPlanPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.ADD_WORKPLAN.VIEW);
        return Pages.VIEWS.ADD_WORKPLAN.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.LOGIN.PATH)
    public String getLoginPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.LOGIN.VIEW);
        return Pages.VIEWS.LOGIN.VIEW;
    }

    protected void processRequest(Model model, HttpSession session, String view) {
        ModelProvider modelProvider = modelProviders.get(view);
        if (modelProvider != null) {
            modelProvider.fillModel(model, session);
        }
    }

    @Required
    public void setModelProviders(Map<String, ModelProvider> modelProviders) {
        this.modelProviders = modelProviders;
    }
}
