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
    private Boolean alertSent = false;

    @PrePersist
    void checkIn() {
        this.checkInTime = LocalDateTime.now();
    }

    // getters and setters
}
