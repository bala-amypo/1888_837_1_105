package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.HostRepository;

@Service
public class AppointmentServiceImpl {

    public AppointmentServiceImpl(
            AppointmentRepository appointmentRepository,
            VisitorRepository visitorRepository,
            HostRepository hostRepository
    ) {}
}
