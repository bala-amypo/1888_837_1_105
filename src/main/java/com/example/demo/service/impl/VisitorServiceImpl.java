package com.example.demo.serviceimpl;

import com.example.demo.entity.Visitor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {

    private VisitorRepository visitorRepository;

    public VisitorServiceImpl() {}

    public VisitorServiceImpl(VisitorRepository repo) {
        this.visitorRepository = repo;
    }

    @Override
    public Visitor createVisitor(Visitor v) {
        return visitorRepository.save(v);
    }

    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
