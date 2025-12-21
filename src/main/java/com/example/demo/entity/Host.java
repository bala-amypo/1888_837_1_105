package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hosts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hostName;
    private String fullname;
    private String email;
    private String department;
    private String phone;

    private LocalDateTime createdAt;

    @PrePersist
    void created() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
