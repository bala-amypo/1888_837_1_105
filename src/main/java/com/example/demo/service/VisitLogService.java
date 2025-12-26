package com.example.demo.service;

import com.example.demo.entity.VisitLog;
import java.util.List;

public interface VisitLogService {

    VisitLog createVisitLog(VisitLog visitLog);

    List<VisitLog> getAllVisitLogs();
}
