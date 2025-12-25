package com.example.demo.service;

import com.example.demo.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByHost(Long hostId);
    List<Appointment> getAppointmentsByVisitor(Long visitorId);
}
