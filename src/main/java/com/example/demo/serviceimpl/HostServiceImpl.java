package com.example.demo.serviceimpl;

import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository repo;

    public HostServiceImpl(HostRepository repo) {
        this.repo = repo;
    }

    @Override
    public Host createHost(Host host) {
        return repo.save(host);
    }

    @Override
    public Host getHost(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }

    @Override
    public List<Host> getAllHosts() {
        return repo.findAll();
    }
}
