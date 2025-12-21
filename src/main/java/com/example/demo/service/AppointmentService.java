package com.example.demo.service;

import com.example.demo.entity.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Long visitorId, Long hostId, Appointment appointment);

    List<Appointment> getAppointmentsForHost(Long hostId);

    List<Appointment> getAppointmentsForVisitor(Long visitorId);

    Appointment getAppointment(Long appointmentId);
}
