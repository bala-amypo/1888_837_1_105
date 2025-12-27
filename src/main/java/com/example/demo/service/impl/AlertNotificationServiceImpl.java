package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertRepository;
    private final VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl(AlertNotificationRepository alertRepository,
                                        VisitLogRepository visitLogRepository) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {

        VisitLog visitLog = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        if (!visitLog.isCheckedIn()) {
            throw new IllegalStateException("Cannot send alert before check-in");
        }

        if (alertRepository.existsByVisitLog(visitLog)) {
            throw new IllegalArgumentException("Duplicate alert");
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(visitLog);
        alert.setAlertMessage("Visitor arrived");
        alert.setSent(true);
        alert.setSentAt(LocalDateTime.now());

        return alertRepository.save(alert);
    }

    @Override
    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}
