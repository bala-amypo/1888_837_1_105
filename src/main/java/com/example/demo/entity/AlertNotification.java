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
        this.sentAt = LocalDateTime.now();
    }

    // getters and setters
}
