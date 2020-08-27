package ru.easyum.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "birth")
    private Date birthDate;
    @Column(name = "scope")
    private long scope;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<ru.easyum.domain.Course> courses;

    public Student(String fio, Date birthDate, long scope, List<Course> courses) {
        this.fio = fio;
        this.birthDate = birthDate;
        this.scope = scope;
        this.courses = courses;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
