package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "alert_notifications",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "visit_log_id")
    }
)
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "visit_log_id", nullable = false, unique = true)
    private VisitLog visitLog;

    @Email(message = "Sent to must be a valid email")
    @Column(name = "sent_to")
    private String sentTo;

    @NotBlank(message = "Alert message is required")
    @Column(name = "alert_message", nullable = false)
    private String alertMessage;

    @Column(name = "sent_at", updatable = false)
    private LocalDateTime sentAt;

    public AlertNotification() {
    }

    public AlertNotification(VisitLog visitLog, String sentTo, String alertMessage) {
        this.visitLog = visitLog;
        this.sentTo = sentTo;
        this.alertMessage = alertMessage;
    }

    @PrePersist
    protected void onSend() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
