package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert_notifications")
@Getter
@Setter
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "visit_log_id", unique = true)
    private VisitLog visitLog;

    private String sentTo;

    private String alertMessage;

    private LocalDateTime sentAt;

    @PrePersist
    public void onSend() {
        this.sentAt = LocalDateTime.now();
    }
}
