package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/host/{hostId}")
    public List<Appointment> getAppointmentsByHost(@PathVariable Long hostId) {
        return appointmentService.getAppointmentsByHost(hostId);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<Appointment> getAppointmentsByVisitor(@PathVariable Long visitorId) {
        return appointmentService.getAppointmentsByVisitor(visitorId);
    }
}
