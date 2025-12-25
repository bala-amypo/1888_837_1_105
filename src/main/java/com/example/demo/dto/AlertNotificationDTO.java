package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlertNotificationDTO {

    private Long id;
    private Long visitLogId;
    private String sentTo;
    private String alertMessage;
    private LocalDateTime sentAt;
}
