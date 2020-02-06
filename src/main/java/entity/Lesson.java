package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
public class Lesson {

    private String teacher;
    private Date date;
    private Time time;
    private String subject;
    private String topic;
    private String group;
    @Id
    private long id;

    public Lesson(String teacher, String subject, String topic, Date date) {
        this.teacher = teacher;
        this.subject = subject;
        this.topic = topic;
        this.date = date;

    }
    public Lesson() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "teacher='" + teacher + '\'' +
                ", date=" + date +
                ", subject='" + subject + '\'' +
                ", topic='" + topic + '\'' +
                ", group='" + group + '\'' +
                ", id=" + id +
                '}';
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
