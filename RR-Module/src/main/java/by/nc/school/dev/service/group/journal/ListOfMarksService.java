package by.nc.school.dev.service.group.journal;

import by.nc.school.dev.entity.ListOfMarks;
import by.nc.school.dev.entity.Mark;

public interface ListOfMarksService {

    ListOfMarks initListOfMarks();

    void putMark(ListOfMarks listOfMarks, String lessonName, Mark mark);
}
