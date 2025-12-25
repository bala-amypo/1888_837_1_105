package com.example.demo.serviceimpl;

import com.example.demo.entity.Host;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;

public class HostServiceImpl implements HostService {

    private HostRepository hostRepository;

    public HostServiceImpl() {}

    @Override
    public Host createHost(Host h) {
        return hostRepository.save(h);
    }

    @Override
    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }
}
