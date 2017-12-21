package by.nc.school.dev.web.provider;

import by.nc.school.dev.Role;
import by.nc.school.dev.entity.Tutor;
import by.nc.school.dev.repository.GroupRepository;
import by.nc.school.dev.repository.PersonRepository;
import by.nc.school.dev.repository.SubjectRepository;
import by.nc.school.dev.repository.UserRepository;
import by.nc.school.dev.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public class AddWorkPlanModelProvider implements ModelProvider {

    protected PersonRepository<Tutor> personRepository;

    protected GroupRepository groupRepository;

    protected SubjectRepository subjectRepository;

    private AddWorkPlanModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        model.addAttribute("groups", groupRepository.findAll());
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
}
