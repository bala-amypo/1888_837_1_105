package com.example.demo.controller;

import com.example.demo.entity.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/{visitLogId}")
    public AlertNotification sendAlert(@PathVariable Long visitLogId) {
        return alertService.sendAlert(visitLogId);
    }
}
