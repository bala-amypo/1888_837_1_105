package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentDTO {

    private Long id;
    private Long visitorId;
    private Long hostId;
    private LocalDate appointmentDate;
    private String purpose;
    private String status;
}
