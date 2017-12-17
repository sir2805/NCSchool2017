package by.nc.school.dev.web.provider;

import by.nc.school.dev.web.controller.SessionAttributes;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class AddGroupModelProvider implements ModelProvider {

    private AddGroupModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        model.addAttribute("students", session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS));
    }
}
