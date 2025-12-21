package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;

@Service
public class AlertNotificationServiceImpl {

    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertNotificationRepository,
            VisitLogRepository visitLogRepository
    ) {}
}
