package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/check-in")
    public VisitLog checkIn(@RequestBody VisitLog visitLog) {
        return visitLogService.checkIn(visitLog);
    }

    @PutMapping("/check-out/{id}")
    public VisitLog checkOut(@PathVariable Long id) {
        return visitLogService.checkOut(id);
    }

    @GetMapping("/active")
    public List<VisitLog> getActiveVisits() {
        return visitLogService.getActiveVisits();
    }
}
