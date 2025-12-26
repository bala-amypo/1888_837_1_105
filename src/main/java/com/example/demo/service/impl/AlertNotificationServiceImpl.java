package com.example.demo.service.impl;

import com.example.demo.entity.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertNotificationRepository;

    public AlertNotificationServiceImpl(AlertNotificationRepository alertNotificationRepository) {
        this.alertNotificationRepository = alertNotificationRepository;
    }

    @Override
    public AlertNotification save(AlertNotification alert) {
        return alertNotificationRepository.save(alert);
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertNotificationRepository.findAll();
    }
}
