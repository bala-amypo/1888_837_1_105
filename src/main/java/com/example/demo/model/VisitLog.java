package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
@Getter
@Setter
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private String purpose;

    private Boolean accessGranted;

    private Boolean alertSent;

    @PrePersist
    public void onCheckIn() {
        this.checkInTime = LocalDateTime.now();
        this.alertSent = false;
    }
}
