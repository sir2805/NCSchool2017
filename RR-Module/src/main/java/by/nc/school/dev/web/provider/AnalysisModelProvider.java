package by.nc.school.dev.web.provider;

import by.nc.school.dev.entity.Student;
import by.nc.school.dev.entity.Subject;
import by.nc.school.dev.service.AnalysisService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalysisModelProvider implements ModelProvider {

    AnalysisService analysisService;

    @Override
    public void fillModel(Model model, HttpSession session) {
        Map<Student, List<Subject>> badStudents = analysisService.findAllStudentsWithBadAverageMark();
        List<String> badStudentsInfo = new ArrayList<>();
        for (Student badstudent : badStudents.keySet()) {
            for (Subject subject : badStudents.get(badstudent)) {
                badStudentsInfo.add(badstudent.toString() + " at subject " + subject);
            }
        }
        model.addAttribute("badstudentsinfo", badStudentsInfo);
        model.addAttribute("goodstudents", analysisService.findAllStudentsWithExcellentMarks());
    }

    @Required
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }
}
