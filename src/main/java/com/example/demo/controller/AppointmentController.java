package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Appointment scheduling")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public ResponseEntity<ApiResponse> create(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody Appointment appointment) {

        return new ResponseEntity<>(
                new ApiResponse(
                        true,
                        "Appointment created",
                        appointmentService.createAppointment(visitorId, hostId, appointment)
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/host/{hostId}")
    public ResponseEntity<ApiResponse> byHost(@PathVariable Long hostId) {
        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        "Appointments for host",
                        appointmentService.getAppointmentsForHost(hostId)
                )
        );
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<ApiResponse> byVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        "Appointments for visitor",
                        appointmentService.getAppointmentsForVisitor(visitorId)
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse(true, "Appointment", appointmentService.getAppointment(id))
        );
    }
}
