package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public VisitLog checkIn(@PathVariable Long visitorId,
                            @PathVariable Long hostId,
                            @RequestBody String purpose) {
        return service.checkInVisitor(visitorId, hostId, purpose);
    }

    @PostMapping("/checkout/{visitLogId}")
    public VisitLog checkOut(@PathVariable Long visitLogId) {
        return service.checkOutVisitor(visitLogId);
    }

    @GetMapping("/active")
    public List<VisitLog> active() {
        return service.getActiveVisits();
    }

    @GetMapping("/{id}")
    public VisitLog one(@PathVariable Long id) {
        return service.getVisitLog(id);
    }
}
