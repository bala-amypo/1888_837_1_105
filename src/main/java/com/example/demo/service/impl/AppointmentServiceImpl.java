package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public AppointmentServiceImpl() {}

    public AppointmentServiceImpl(AppointmentRepository a,
                                  VisitorRepository v,
                                  HostRepository h) {
        this.appointmentRepository = a;
        this.visitorRepository = v;
        this.hostRepository = h;
    }

    @Override
    public Appointment createAppointment(Long visitorId, Long hostId, Appointment ap) {

        if (ap.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("appointmentDate cannot be past");
        }

        Visitor v = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        Host h = hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        ap.setVisitor(v);
        ap.setHost(h);
        ap.setStatus("SCHEDULED");

        return appointmentRepository.save(ap);
    }

    @Override
    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
    }

    @Override
    public List<Appointment> getAppointmentsForHost(Long id) {
        return appointmentRepository.findByHostId(id);
    }

    @Override
    public List<Appointment> getAppointmentsForVisitor(Long id) {
        return appointmentRepository.findByVisitorId(id);
    }
}
