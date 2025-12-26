package com.example.demo.service;

import com.example.demo.entity.AlertNotification;

import java.util.List;

public interface AlertNotificationService {

    AlertNotification save(AlertNotification alert);

    List<AlertNotification> getAllAlerts();
    
    AlertNotification sendAlert(Long visitLogId);

    AlertNotification getAlert(Long id);
}
