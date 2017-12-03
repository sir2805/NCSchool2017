package by.nc.school.dev.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Mark {
    @Column(name = "mark")
    private int mark;
    @Column(name = "is_exam")
    private boolean isExam;

    private Mark() {}

    public Mark(int mark, boolean isExam) {
        this.mark = mark;
        this.isExam = isExam;
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
}
