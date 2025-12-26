package com.example.demo.service.impl;

import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host saveHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    @Override
    public Host getHostById(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
    }
}
