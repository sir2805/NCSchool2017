package by.nc.school.dev.enitities;

public class Curator extends Tutor {

    private int groupNumber;

    public Curator(int id, int userRole, String login, String password, String fullName, int groupNumber) {
        super(id, userRole, login, password, fullName);
        this.groupNumber = groupNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "groupNumber=" + groupNumber +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", id=" + id +
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
