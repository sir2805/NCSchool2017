package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.ListOfMarks;
import by.nc.school.dev.repository.ListOfMarksRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class ListOfMarksServiceImpl implements ListOfMarksService {

    protected ListOfMarksRepository listOfMarksRepository;

    @Override
    @Transactional
    public ListOfMarks initListOfMarks() {

        ListOfMarks listOfMarks = new ListOfMarks();
        listOfMarksRepository.save(listOfMarks);
        return listOfMarks;
    }

    @Required
    public void setListOfMarksRepository(ListOfMarksRepository listOfMarksRepository) {
        this.listOfMarksRepository = listOfMarksRepository;
    }
}
