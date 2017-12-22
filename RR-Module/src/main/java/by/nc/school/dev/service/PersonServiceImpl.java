package by.nc.school.dev.service;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class PersonServiceImpl implements PersonService {

    protected PersonRepository<Person> personRepository;

    protected PersonRepository<Curator> curatorPersonRepository;

    protected AppStringsService appStringsService;

    @Override
    public Person createPerson(String fullname, String role, Group group) {
        if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.STUDENT.KEY))) {
            return new Student(fullname, group);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.TUTOR.KEY))) {
            //TODO save tutor not curator
            return new Curator(fullname, null);
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

    @Override
    public void removePerson(Person person) {
        personRepository.delete(person);
    }

    @Transactional
    @Override
    public Curator changeTutorToCurator(Tutor tutor, Group group) {
        Long id = tutor.getId();
        Curator curator = new Curator(tutor.getFullname(), group);
        curator.setId(id);
        personRepository.addCuratorForExistingTutor(curator.getId(), curator.getGroup().getId());
        return curator;
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void saveNewlyAddedCurator(Curator curator) {
        personRepository.addCuratorForExistingTutor(curator.getId(), curator.getGroup().getId());
    }

    @Required
    public void setCuratorPersonRepository(PersonRepository<Curator> curatorPersonRepository) {
        this.curatorPersonRepository = curatorPersonRepository;
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
