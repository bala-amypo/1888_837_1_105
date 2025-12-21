package com.example.demo.service.impl;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public Appointment createAppointment(Long visitorId, Long hostId, Appointment appointment) {
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsForHost(Long hostId) {
        return Collections.emptyList();
    }

    @Override
    public List<Appointment> getAppointmentsForVisitor(Long visitorId) {
        return Collections.emptyList();
    }

    @Override
    public Appointment getAppointment(Long appointmentId) {
        return null;
    }
}
