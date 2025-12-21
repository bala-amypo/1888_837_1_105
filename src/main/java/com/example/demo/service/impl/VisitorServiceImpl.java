package com.example.demo.service.impl;

import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Override
    public Visitor createVisitor(Visitor visitor) {
        return visitor;
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return Collections.emptyList();
    }

    @Override
    public Visitor getVisitor(Long visitorId) {
        return null;
    }
}
