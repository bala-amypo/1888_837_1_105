package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.HostRepository;

@Service
public class VisitLogServiceImpl {

    public VisitLogServiceImpl(
            VisitLogRepository visitLogRepository,
            VisitorRepository visitorRepository,
            HostRepository hostRepository
    ) {}
}
