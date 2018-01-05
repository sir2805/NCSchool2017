package by.nc.school.dev.service;

import by.nc.school.dev.entity.Student;
import by.nc.school.dev.entity.Subject;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnalysisService {

    Map<Student, List<Subject>> findAllStudentsWithBadAverageMark();

    Set<Student> findAllStudentsWithExcellentMarks();
}
