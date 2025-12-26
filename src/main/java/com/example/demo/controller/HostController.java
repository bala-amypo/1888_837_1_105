package com.example.demo.controller;

import com.example.demo.entity.Host;
import com.example.demo.service.HostService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public Host createHost(@RequestBody Host host) {
        return hostService.saveHost(host);
    }

    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    @GetMapping("/{id}")
    public Host getHostById(@PathVariable Long id) {
        return hostService.getHostById(id);
    }
}
