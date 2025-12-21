package com.example.demo.controller;

import com.example.demo.service.AlertNotificationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertNotificationController {

    private final AlertNotificationService service;

    public AlertNotificationController(AlertNotificationService service) {
        this.service = service;
    }
}
