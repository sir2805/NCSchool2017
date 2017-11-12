package by.nc.school.dev.enitities;

public class Subject extends BaseEntity {

    private String name;
    private Tutor tutor;

    public Subject(int id, String name, Tutor tutor) {
        super(id);
        this.name = name;
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", tutor=" + tutor +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
