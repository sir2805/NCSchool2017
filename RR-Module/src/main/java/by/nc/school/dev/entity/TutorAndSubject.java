package by.nc.school.dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "tutor_and_subject")
public class TutorAndSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public TutorAndSubject() {
    }

    public TutorAndSubject(Tutor tutor, Subject subject) {
        this.tutor = tutor;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
