package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService service;

    public HostController(HostService service) {
        this.service = service;
    }

    @PostMapping
    public Host create(@RequestBody Host host) {
        return service.createHost(host);
    }

    @GetMapping
    public List<Host> getAll() {
        return service.getAllHosts();
    }

    @GetMapping("/{id}")
    public Host get(@PathVariable Long id) {
        return service.getHost(id);
    }
}
