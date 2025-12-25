package com.example.demo.service;

import com.example.demo.entity.AlertNotification;

public interface AlertNotificationService {
    AlertNotification sendAlert(Long visitLogId);
}
