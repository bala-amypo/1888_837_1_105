package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "visitors")
@Getter
@Setter
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String fullName;

    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String idProofNumber;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL)
    private List<VisitLog> visitLogs;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
