package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Host;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class VisitLogServiceImpl implements VisitLogService {

    // ⚠️ REQUIRED FIELD NAMES
    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    // ✔ EMPTY constructor for reflection injection
    public VisitLogServiceImpl() {
    }

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository,
                               VisitorRepository visitorRepository,
                               HostRepository hostRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitor not found"));

        Host host = hostRepository.findById(hostId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setHost(host);
        log.setPurpose(purpose);
        log.setAccessGranted(true);
        log.setAlertSent(false);

        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("VisitLog not found"));

        if (log.getCheckInTime() == null || log.getCheckOutTime() != null) {
            throw new IllegalStateException("Visitor not checked in");
        }

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }

    @Override
    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("VisitLog not found"));
    }
}
