package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role = "USER";

    private LocalDateTime createdAt;

    @PrePersist
    void created() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
