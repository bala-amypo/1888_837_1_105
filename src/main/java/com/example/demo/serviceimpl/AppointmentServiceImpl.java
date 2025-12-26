package com.example.demo.serviceimpl;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return repo.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByHost(Long hostId) {
        return repo.findByHostId(hostId);
    }

    @Override
    public List<Appointment> getAppointmentsByVisitor(Long visitorId) {
        return repo.findByVisitorId(visitorId);
    }
}
