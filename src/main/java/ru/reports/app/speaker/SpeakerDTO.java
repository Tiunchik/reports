package ru.reports.app.speaker;

import ru.reports.app.report.Report;
import java.util.ArrayList;
import java.util.List;

public class SpeakerDTO {

    private int id;

    private String name;

    private String patronim;

    private String surname;

    private List<Report> reports = new ArrayList<>();

    public SpeakerDTO() {
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

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
