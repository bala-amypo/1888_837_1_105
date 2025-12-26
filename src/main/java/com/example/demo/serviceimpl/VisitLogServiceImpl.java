package com.example.demo.serviceimpl;

import com.example.demo.entity.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository visitLogRepository;

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository) {
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public VisitLog createVisitLog(VisitLog visitLog) {
        return visitLogRepository.save(visitLog);
    }

    @Override
    public List<VisitLog> getAllVisitLogs() {
        return visitLogRepository.findAll();
    }
}
