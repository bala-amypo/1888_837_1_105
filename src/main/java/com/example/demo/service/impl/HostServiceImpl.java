package com.example.demo.service.impl;

import com.example.demo.entity.Host;
import com.example.demo.service.HostService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    @Override
    public Host createHost(Host host) {
        return host;
    }

    @Override
    public List<Host> getAllHosts() {
        return Collections.emptyList();
    }

    @Override
    public Host getHost(Long hostId) {
        return null;
    }
}
