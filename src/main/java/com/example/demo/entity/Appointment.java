package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private Host host;

    private LocalDate appointmentDate;
    private String purpose;
    private String status;

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public Host getHost() {
        return host;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getStatus() {
        return status;
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

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
