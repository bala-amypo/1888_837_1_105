package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "hosts",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@Getter
@Setter
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String hostName;

    private String fullname;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String department;

    @NotBlank
    private String phone;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<VisitLog> visitLogs;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
