package by.nc.school.dev.web.provider;

import by.nc.school.dev.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class AddUserModelProvider implements ModelProvider {

    protected GroupRepository groupRepository;

    private AddUserModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        model.addAttribute("groups", groupRepository.findAll());
    }

    @Required
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
