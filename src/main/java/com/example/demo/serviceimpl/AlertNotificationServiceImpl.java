package com.example.demo.serviceimpl;

import com.example.demo.entity.AlertNotification;
import com.example.demo.entity.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertRepo;
    private final VisitLogRepository visitLogRepo;

    public AlertNotificationServiceImpl(AlertNotificationRepository alertRepo,
                                        VisitLogRepository visitLogRepo) {
        this.alertRepo = alertRepo;
        this.visitLogRepo = visitLogRepo;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog log = visitLogRepo.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo("ADMIN");
        alert.setAlertMessage("Visitor alert generated");

        return alertRepo.save(alert);
    }
}
