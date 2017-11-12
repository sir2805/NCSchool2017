package by.nc.school.dev.enitities;

public abstract class BaseEntity {
    protected int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
