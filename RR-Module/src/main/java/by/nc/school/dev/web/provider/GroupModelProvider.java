package by.nc.school.dev.web.provider;

import by.nc.school.dev.repository.UserRepository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class GroupModelProvider implements ModelProvider {

    protected UserRepository userRepository;
    @Override
    public void fillModel(Model model, HttpSession session) {

    }

}
