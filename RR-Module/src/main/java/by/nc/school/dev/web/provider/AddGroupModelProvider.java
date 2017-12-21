package by.nc.school.dev.web.provider;

import by.nc.school.dev.Role;
import by.nc.school.dev.repository.UserRepository;
import by.nc.school.dev.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class AddGroupModelProvider implements ModelProvider {

    protected UserRepository userRepository;

    private AddGroupModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        model.addAttribute("students", session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS));
        model.addAttribute("tutors", userRepository.findAllByPersonRole(Role.TUTOR));
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
