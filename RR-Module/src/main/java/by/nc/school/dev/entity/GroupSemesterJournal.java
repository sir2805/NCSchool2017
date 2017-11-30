package by.nc.school.dev.entity;

import java.util.Map;

public class GroupSemesterJournal {
    private Map<Subject, GroupSubjectJournal> journal;

    public GroupSemesterJournal(Map<Subject, GroupSubjectJournal> journal) {
        this.journal = journal;
    }

    public Map<Subject, GroupSubjectJournal> getJournal() {
        return journal;
    }

    public void setJournal(Map<Subject, GroupSubjectJournal> journal) {
        this.journal = journal;
    }
}
