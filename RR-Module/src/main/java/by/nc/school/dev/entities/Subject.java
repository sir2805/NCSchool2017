package by.nc.school.dev.entities;

public class Subject extends BaseEntity {

    private String name;

    public Subject(int id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
