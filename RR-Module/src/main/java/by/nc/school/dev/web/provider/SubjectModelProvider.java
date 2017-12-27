package by.nc.school.dev.web.provider;

import by.nc.school.dev.entity.Subject;
import by.nc.school.dev.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public class SubjectModelProvider implements ModelProvider {

    protected SubjectRepository subjectRepository;

    @Override
    public void fillModel(Model model, HttpSession session) {
        List<Subject> subjectList = subjectRepository.findAll();
        model.addAttribute("subjects", subjectList);
    }

    @Required
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
}
