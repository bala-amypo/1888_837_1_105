package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "hosts",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Host name is required")
    @Column(name = "host_name", nullable = false)
    private String hostName;

    @Column(name = "full_name")
    private String fullname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Department is required")
    @Column(name = "department", nullable = false)
    private String department;

    @NotBlank(message = "Phone number is required")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Host() {
    }

    public Host(String hostName, String fullname, String email, String department, String phone) {
        this.hostName = hostName;
        this.fullname = fullname;
        this.email = email;
        this.department = department;
        this.phone = phone;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
