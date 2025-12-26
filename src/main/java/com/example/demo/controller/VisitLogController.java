package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitlogs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping
    public VisitLog create(@RequestBody VisitLog visitLog) {
        return visitLogService.createVisitLog(visitLog);
    }

    @GetMapping
    public List<VisitLog> getAll() {
        return visitLogService.getAllVisitLogs();
    }
}
