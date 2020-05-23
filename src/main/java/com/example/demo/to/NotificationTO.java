package com.example.demo.to;

public class NotificationTO {
    private String heading;
    private String message;
    private String headingColor;
    private  String headingTextColor;
    private String bodyColor;
    private String bodyTextColor;
    private String timeNotification;
    private String timerInterval;

    public NotificationTO(){}

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHeadingColor() {
        return headingColor;
    }

    public void setHeadingColor(String headingColor) {
        this.headingColor = headingColor;
    }

    public String getHeadingTextColor() {
        return headingTextColor;
    }

    public void setHeadingTextColor(String headingTextColor) {
        this.headingTextColor = headingTextColor;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getBodyTextColor() {
        return bodyTextColor;
    }

    public void setBodyTextColor(String bodyTextColor) {
        this.bodyTextColor = bodyTextColor;
    }

    public String getTimeNotification() {
        return timeNotification;
    }

    public void setTimeNotification(String timeNotification) {
        this.timeNotification = timeNotification;
    }

    public String getTimerInterval() {
        return timerInterval;
    }

    public void setTimerInterval(String timerInterval) {
        this.timerInterval = timerInterval;
    }
}
