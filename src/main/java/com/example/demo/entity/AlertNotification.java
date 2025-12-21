package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sentTo;
    private String alertMessage;

    @ManyToOne
    private VisitLog visitLog;

    public Long getId() {
        return id;
    }

    public String getSentTo() {
        return sentTo;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }
}
