package by.nc.school.dev.enitities;


public class Student extends User {

    private int groupNumber;

    public Student(int id, int userRole, String login, String password, String fullName, int groupNumber) {
        super(id, userRole, login, password, fullName);
        this.groupNumber = groupNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
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
