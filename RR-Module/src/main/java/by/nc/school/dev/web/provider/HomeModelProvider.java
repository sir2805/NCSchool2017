package by.nc.school.dev.web.provider;

import by.nc.school.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


public class HomeModelProvider implements ModelProvider {

    protected UserRepository userRepository;

    private HomeModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        model.addAttribute("users", userRepository.findAll());
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
