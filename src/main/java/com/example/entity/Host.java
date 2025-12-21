package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "hosts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String hostName;

    private String fullName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String department;

    @NotBlank
    private String phone;

    private LocalDateTime createdAt;

    @PrePersist
    void created() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getHostName() { return hostName; }
    public void setHostName(String hostName) { this.hostName = hostName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
