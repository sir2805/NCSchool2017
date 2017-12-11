package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;
import org.springframework.beans.factory.annotation.Required;

public class PersonServiceImpl implements PersonService {

    protected AppStringsService appStringsService;

    @Override
    public Person createPerson(String fullname, String role, Group group) {
        if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.STUDENT.KEY))) {
            return new Student(fullname, group);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.TUTOR.KEY))) {
            return new Tutor(fullname);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.CURATOR.KEY))) {
            return new Curator(fullname, group);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.DEAN.KEY))) {
            return new Dean(fullname);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.ADMIN.KEY))) {
            return new Admin(fullname);
        } else {
            return null;
        }
    }

    @Required
    public void setAppStringsService(AppStringsService appStringsService) {
        this.appStringsService = appStringsService;
    }
}
