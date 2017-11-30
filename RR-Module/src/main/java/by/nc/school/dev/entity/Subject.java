package by.nc.school.dev.entity;

public class Subject {

    private Long id;
    private String name;

    public Subject(Long id, String name) {
        this.id = id;
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
