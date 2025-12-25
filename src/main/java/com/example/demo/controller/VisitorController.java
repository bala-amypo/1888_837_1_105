package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public Visitor create(@RequestBody Visitor v) {
        return visitorService.createVisitor(v);
    }

    @GetMapping
    public List<Visitor> all() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/{id}")
    public Visitor one(@PathVariable Long id) {
        return visitorService.getVisitor(id);
    }
}
