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

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public Host getHost() {
        return host;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
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

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}
