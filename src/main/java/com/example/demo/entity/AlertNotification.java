package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_notifications")
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private VisitLog visitLog;

    private String sentTo;
    private String alertMessage;
    private LocalDateTime sentAt;

    @PrePersist
    void sent() {
        sentAt = LocalDateTime.now();
    }

    public void setVisitLog(VisitLog visitLog) { this.visitLog = visitLog; }
    public void setSentTo(String sentTo) { this.sentTo = sentTo; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }
}
