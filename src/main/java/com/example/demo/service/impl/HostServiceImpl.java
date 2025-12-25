package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;

import java.util.List;

public class HostServiceImpl implements HostService {

    // ⚠️ REQUIRED FIELD NAME
    private HostRepository hostRepository;

    // ✔ EMPTY constructor needed by tests
    public HostServiceImpl() {
    }

    // ✔ Constructor injection (used in real app)
    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Host not found"));
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}
