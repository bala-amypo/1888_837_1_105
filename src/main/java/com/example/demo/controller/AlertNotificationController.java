package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    private final AlertNotificationService service;

    public AlertNotificationController(AlertNotificationService service) {
        this.service = service;
    }

    @PostMapping("/send/{visitLogId}")
    public AlertNotification send(@PathVariable Long visitLogId) {
        return service.sendAlert(visitLogId);
    }

    @GetMapping("/{id}")
    public AlertNotification get(@PathVariable Long id) {
        return service.getAlert(id);
    }

    @GetMapping
    public List<AlertNotification> all() {
        return service.getAllAlerts();
    }
}
