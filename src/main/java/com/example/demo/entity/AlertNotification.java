package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertMessage;

    private String sentTo;

    private boolean sent;

    private LocalDateTime sentAt;

    @ManyToOne
    private VisitLog visitLog;

    public AlertNotification() {}

    public Long getId() {
        return id;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public String getSentTo() {
        return sentTo;
    }

    public boolean isSent() {
        return sent;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }
}
