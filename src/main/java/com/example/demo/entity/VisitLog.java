package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private Host host;

    private String purpose;
    private boolean accessGranted;
    private boolean alertSent;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public Host getHost() {
        return host;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean isAccessGranted() {
        return accessGranted;
    }

    public boolean isAlertSent() {
        return alertSent;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setAccessGranted(boolean accessGranted) {
        this.accessGranted = accessGranted;
    }

    public void setAlertSent(boolean alertSent) {
        this.alertSent = alertSent;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
