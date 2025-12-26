package com.example.demo.serviceimpl;

import com.example.demo.entity.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.VisitLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository repo;

    public VisitLogServiceImpl(VisitLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public VisitLog checkIn(VisitLog visitLog) {
        visitLog.setCheckInTime(LocalDateTime.now());
        return repo.save(visitLog);
    }

    @Override
    public VisitLog checkOut(Long id) {
        VisitLog log = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
        log.setCheckOutTime(LocalDateTime.now());
        return repo.save(log);
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return repo.findByCheckOutTimeIsNull();
    }
}
