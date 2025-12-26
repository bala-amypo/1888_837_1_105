package com.example.demo.serviceimpl;

import com.example.demo.entity.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository repository;

    public AlertNotificationServiceImpl(AlertNotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlertNotification createAlert(AlertNotification alert) {
        alert.setSent(true);
        alert.setSentAt(LocalDateTime.now());
        return repository.save(alert);
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return repository.findAll();
    }
}
