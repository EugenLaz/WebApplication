package entity;

import java.time.LocalDateTime;


public class LessonRequest {
    private long pricePerHour;
    private String place;
    private LocalDateTime dateTime;
    private String message;
    private String studentID;
    private String tutuorID;
    private boolean approval;
    public LessonRequest() {
    }
    public LessonRequest(long pricePerHour, String place, LocalDateTime dateTime, String studentID, String tutuorID) {
        this.pricePerHour = pricePerHour;
        this.place = place;
        this.dateTime = dateTime;
        this.studentID = studentID;
        this.tutuorID = tutuorID;
    }

    @Override
    public String toString() {
        return "LessonRequest{" +
                "pricePerHour=" + pricePerHour +
                ", place='" + place + '\'' +
                ", dateTime=" + dateTime +
                ", message='" + message + '\'' +
                ", studentID='" + studentID + '\'' +
                ", tutuorID='" + tutuorID + '\'' +
                ", approval=" + approval +
                '}';
    }

    public long getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTutuorID() {
        return tutuorID;
    }

    public void setTutuorID(String tutuorID) {
        this.tutuorID = tutuorID;
    }
}
