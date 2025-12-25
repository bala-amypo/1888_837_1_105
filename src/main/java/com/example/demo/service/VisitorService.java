package com.example.demo.service;

import com.example.demo.entity.Visitor;
import java.util.List;

public interface VisitorService {

    Visitor createVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    // 🔥 ADD THIS METHOD
    Visitor getVisitor(Long id);

    Visitor updateVisitor(Long id, Visitor visitor);

    void deleteVisitor(Long id);
}
