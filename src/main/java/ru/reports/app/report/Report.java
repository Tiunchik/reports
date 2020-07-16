package ru.reports.app.report;

import org.springframework.stereotype.Component;
import ru.reports.app.speaker.Speaker;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Component
@Entity(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Speaker owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Speaker getOwner() {
        return owner;
    }

    public void setOwner(Speaker owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Report report = (Report) o;
        return id == report.id
                && theme.equals(report.theme)
                && time.equals(report.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, time);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
