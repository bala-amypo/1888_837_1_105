package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String idProofNumber;

    private LocalDateTime createdAt;

    @PrePersist
    void created() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
