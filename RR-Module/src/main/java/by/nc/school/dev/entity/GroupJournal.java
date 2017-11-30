package by.nc.school.dev.entity;

import java.util.Map;

public class GroupJournal {

    private Map<Semester, GroupSemesterJournal>groupJournal;
    private Group group;

    public GroupJournal(Map<Semester, GroupSemesterJournal> groupJournal, Group group) {
        this.groupJournal = groupJournal;
        this.group = group;
    }

    @Override
    public String toString() {
        return "GroupJournal{" +
                "groupJournal=" + groupJournal +
                ", group=" + group +
                '}';
    }

    public Map<Semester, GroupSemesterJournal> getGroupJournal() {
        return groupJournal;
    }

    public void setGroupJournal(Map<Semester, GroupSemesterJournal> groupJournal) {
        this.groupJournal = groupJournal;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
