package by.nc.school.dev.entities;


public class Student extends User {

    private int groupNumber;

    public Student(int id, String fullName, int role, int groupNumber) {
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
        return "Student{" +
                "groupNumber=" + groupNumber +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return groupNumber == student.groupNumber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + groupNumber;
        return result;
    }
}
