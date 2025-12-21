package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.VisitorRepository;

@Service
public class VisitorServiceImpl {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }
}
