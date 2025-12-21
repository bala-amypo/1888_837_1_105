package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private Host host;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String purpose;
    private Boolean accessGranted;
    private Boolean alertSent;

    @PrePersist
    void checkIn() {
        checkInTime = LocalDateTime.now();
        alertSent = false;
    }

    public Long getId() { return id; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }
    public void setHost(Host host) { this.host = host; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public void setAccessGranted(Boolean accessGranted) { this.accessGranted = accessGranted; }
}
