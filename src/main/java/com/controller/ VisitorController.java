package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitors", description = "Visitor management endpoints")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody Visitor visitor) {
        return new ResponseEntity<>(
                new ApiResponse(true, "Visitor created", visitorService.createVisitor(visitor)),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(
                new ApiResponse(true, "All visitors", visitorService.getAllVisitors())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse(true, "Visitor", visitorService.getVisitor(id))
        );
    }
}
