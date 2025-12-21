package com.example.demo.service.impl;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        return null;
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {
        return null;
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return Collections.emptyList();
    }
}
