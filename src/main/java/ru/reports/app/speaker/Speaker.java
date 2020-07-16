package ru.reports.app.speaker;

import org.springframework.stereotype.Component;
import ru.reports.app.report.Report;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Entity(name = "speaker")
@Table(uniqueConstraints =
        {@UniqueConstraint(columnNames = {"name", "patronim", "surname"})})
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "patronim")
    private String patronim;

    @Column(nullable = false, name = "surname")
    private String surname;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Report> reports = new ArrayList<>();

    public Speaker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronim() {
        return patronim;
    }

    public void setPatronim(String patronim) {
        this.patronim = patronim;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Speaker speaker = (Speaker) o;
        return id == speaker.id
                && name.equals(speaker.name)
                && patronim.equals(speaker.patronim)
                && surname.equals(speaker.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patronim, surname);
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patronim='" + patronim + '\'' +
                ", surname='" + surname + '\'' +
                ", reports=" + reports +
                '}';
    }
}
