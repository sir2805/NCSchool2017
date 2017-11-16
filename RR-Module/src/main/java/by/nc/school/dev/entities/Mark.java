package by.nc.school.dev.entities;

public class Mark {

    private int mark;
    private boolean isExam;

    public Mark(int mark, boolean isExam) {
        this.mark = mark;
        this.isExam = isExam;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mark=" + mark +
                ", isExam=" + isExam +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;

        Mark mark1 = (Mark) o;

        if (mark != mark1.mark) return false;
        return isExam == mark1.isExam;
    }

    @Override
    public int hashCode() {
        int result = mark;
        if (isExam) return mark * 31;
        return result;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean getIsExam() {
        return isExam;
    }

    public void setIsExam(boolean isExam) {
        this.isExam = isExam;
    }
}
