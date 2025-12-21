package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.HostRepository;

@Service
public class HostServiceImpl {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }
}
