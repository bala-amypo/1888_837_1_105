package com.example.demo.controller;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public Appointment create(@PathVariable Long visitorId,
                              @PathVariable Long hostId,
                              @RequestBody Appointment a) {
        return service.createAppointment(visitorId, hostId, a);
    }

    @GetMapping("/host/{hostId}")
    public List<Appointment> byHost(@PathVariable Long hostId) {
        return service.getAppointmentsForHost(hostId);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<Appointment> byVisitor(@PathVariable Long visitorId) {
        return service.getAppointmentsForVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public Appointment one(@PathVariable Long id) {
        return service.getAppointment(id);
    }
}
