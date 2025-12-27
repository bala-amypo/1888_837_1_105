package com.example.demo.repository;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertNotificationRepository extends JpaRepository<AlertNotification, Long> {

    boolean existsByVisitLog(VisitLog visitLog);
}
