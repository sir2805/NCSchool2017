package by.nc.school.dev.web.provider;

import by.nc.school.dev.Role;
import by.nc.school.dev.entity.Group;
import by.nc.school.dev.entity.Tutor;
import by.nc.school.dev.repository.GroupRepository;
import by.nc.school.dev.repository.PersonRepository;
import by.nc.school.dev.repository.SubjectRepository;
import by.nc.school.dev.repository.UserRepository;
import by.nc.school.dev.service.group.workplan.GroupWorkPlanService;
import by.nc.school.dev.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddWorkPlanModelProvider implements ModelProvider {

    protected PersonRepository<Tutor> personRepository;

    protected GroupRepository groupRepository;

    protected SubjectRepository subjectRepository;

    protected GroupWorkPlanService groupWorkPlanService;

    private AddWorkPlanModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        List<Group> groups = groupRepository.findAll().stream().filter(group -> !groupWorkPlanService.isWorkPlanForGroupExists(group)).collect(Collectors.toList());
        model.addAttribute("groups", groups);
        List<Tutor> tutors = personRepository.findAllByRole(Role.TUTOR);
        tutors.addAll(personRepository.findAllByRole(Role.CURATOR));
        model.addAttribute("tutors", tutors);
        model.addAttribute("subjects", subjectRepository.findAll());
    }

    public void setPersonRepository(PersonRepository<Tutor> personRepository) {
        this.personRepository = personRepository;
    }

    @Required
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Required
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Required
    public void setGroupWorkPlanService(GroupWorkPlanService groupWorkPlanService) {
        this.groupWorkPlanService = groupWorkPlanService;
    }
}
