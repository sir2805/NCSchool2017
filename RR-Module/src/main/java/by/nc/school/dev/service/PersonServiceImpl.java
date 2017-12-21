package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class PersonServiceImpl implements PersonService {

    protected PersonRepository<Person> personRepository;

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

    @Override
    public Person getPersonByfullname(String fullname) {
        return personRepository.findByFullname(fullname);
    }

    @Transactional
    @Override
    public void removePerson(Person person) {
        personRepository.delete(person);
    }

    @Required
    public void setPersonRepository(PersonRepository<Person> personRepository) {
        this.personRepository = personRepository;
    }

    @Required
    public void setAppStringsService(AppStringsService appStringsService) {
        this.appStringsService = appStringsService;
    }
}
