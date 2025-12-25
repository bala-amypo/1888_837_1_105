package com.example.demo.service;

import com.example.demo.entity.VisitLog;
import java.util.List;

public interface VisitLogService {
    VisitLog checkIn(VisitLog visitLog);
    VisitLog checkOut(Long id);
    List<VisitLog> getActiveVisits();
}
