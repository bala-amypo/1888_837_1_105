package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private boolean sent;

    private LocalDateTime sentAt;

    @ManyToOne
    private Visitor visitor;

    public AlertNotification() {}

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSent() {
        return sent;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
