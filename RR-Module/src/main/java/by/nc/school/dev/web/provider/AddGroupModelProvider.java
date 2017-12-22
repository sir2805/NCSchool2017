package by.nc.school.dev.web.provider;

import by.nc.school.dev.Role;
import by.nc.school.dev.entity.Curator;
import by.nc.school.dev.entity.Person;
import by.nc.school.dev.repository.PersonRepository;
import by.nc.school.dev.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddGroupModelProvider implements ModelProvider {

    protected PersonRepository<Person> personRepository;

    private AddGroupModelProvider() {}

    @Override
    public void fillModel(Model model, HttpSession session) {
        model.addAttribute("students", session.getAttribute(SessionAttributes.CURRENTLY_ADDING_STUDENTS));
        List<Person> tutors = new ArrayList<>();
        for (Person tutor : personRepository.findAllByRole(Role.CURATOR)) {
            if( ((Curator)tutor).getGroup() == null) {
                tutors.add(tutor);
            }
        }
        model.addAttribute("tutors", tutors);
    }

    @Required
    public void setPersonRepository(PersonRepository<Person> personRepository) {
        this.personRepository = personRepository;
    }
}
