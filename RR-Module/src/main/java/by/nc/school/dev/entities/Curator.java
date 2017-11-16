package by.nc.school.dev.entities;

public class Curator extends Tutor {

    private int groupNumber;

    public Curator(int id, String fullName, int role, int groupNumber) {
        super(id, fullName, role);
        this.groupNumber = groupNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "groupNumber=" + groupNumber +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curator)) return false;
        if (!super.equals(o)) return false;

        Curator curator = (Curator) o;

        return groupNumber == curator.groupNumber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + groupNumber;
        return result;
    }
}
