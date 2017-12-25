package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.ListOfMarks;
import by.nc.school.dev.entity.Mark;
import by.nc.school.dev.repository.ListOfMarksRepository;
import org.springframework.beans.factory.annotation.Required;

public class ListOfMarksServiceImpl implements ListOfMarksService {

    protected ListOfMarksRepository listOfMarksRepository;

    @Override
    public ListOfMarks initListOfMarks() {
        ListOfMarks listOfMarks = new ListOfMarks();
        listOfMarksRepository.save(listOfMarks);
        return listOfMarks;
    }

    @Override
    public void putMark(ListOfMarks listOfMarks, String lessonName, Mark mark) {
        listOfMarks.getMarks().put(lessonName, mark);
        listOfMarksRepository.save(listOfMarks);
    }

    @Required
    public void setListOfMarksRepository(ListOfMarksRepository listOfMarksRepository) {
        this.listOfMarksRepository = listOfMarksRepository;
    }
}
