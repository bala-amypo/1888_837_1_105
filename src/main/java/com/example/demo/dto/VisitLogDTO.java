package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VisitLogDTO {

    private Long id;
    private Long visitorId;
    private Long hostId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String purpose;
    private Boolean accessGranted;
}
