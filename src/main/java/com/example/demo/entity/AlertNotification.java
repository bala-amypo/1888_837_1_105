package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    private VisitLog visitLog;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }
}
