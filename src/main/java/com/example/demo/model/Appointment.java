package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    private LocalDate appointmentDate;

    private String purpose;

    private String status; // SCHEDULED, CANCELLED, COMPLETED
}
