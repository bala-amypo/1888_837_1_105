package com.example.demo.service.impl;

import com.example.demo.entity.AlertNotification;
import com.example.demo.entity.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertNotificationRepository;
    private final VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl(AlertNotificationRepository alertNotificationRepository,
                                        VisitLogRepository visitLogRepository) {
        this.alertNotificationRepository = alertNotificationRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public AlertNotification save(AlertNotification alert) {
        return alertNotificationRepository.save(alert);
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertNotificationRepository.findAll();
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog visitLog = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(visitLog);
        alert.setSentAt(LocalDateTime.now());
        alert.setAlertMessage("Visitor alert sent");

        return alertNotificationRepository.save(alert);
    }

    @Override
    public AlertNotification getAlert(Long id) {
        return alertNotificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }
}
