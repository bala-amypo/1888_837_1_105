package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AlertNotification;
import java.util.Optional;

public interface AlertNotificationRepository extends JpaRepository<AlertNotification, Long> {
    Optional<AlertNotification> findByVisitLogId(Long visitLogId);
}
