package com.example.demo.controller;

import com.example.demo.service.VisitLogService;
import com.example.demo.entity.VisitLog;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/visits")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkIn(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody String purpose) {
        return new ResponseEntity<>(
                service.checkInVisitor(visitorId, hostId, purpose),
                HttpStatus.CREATED);
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<VisitLog> checkOut(@PathVariable Long id) {
        return ResponseEntity.ok(service.checkOutVisitor(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<VisitLog>> active() {
        return ResponseEntity.ok(service.getActiveVisits());
    }
}
