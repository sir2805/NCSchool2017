package by.nc.school.dev.service;

import by.nc.school.dev.entity.Semester;
import by.nc.school.dev.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class SemesterServiceImpl implements SemesterService {

    protected SemesterRepository semesterRepository;

    @Override
    @Transactional
    public Semester getFirstSemester() {
        Semester firstSemester = semesterRepository.findBySemesterNumber(1);
        if (firstSemester == null) {
            firstSemester = new Semester(1);
            semesterRepository.save(firstSemester);
        }
        return semesterRepository.findBySemesterNumber(1);
    }

    @Required
    public void setSemesterRepository(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }
}
