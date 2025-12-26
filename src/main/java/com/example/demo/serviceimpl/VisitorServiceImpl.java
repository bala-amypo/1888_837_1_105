package com.example.demo.serviceimpl;

import com.example.demo.entity.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    // 🔥 IMPLEMENTATION ADDED
    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
    }

    @Override
    public Visitor updateVisitor(Long id, Visitor visitor) {
        Visitor existing = getVisitor(id);
        existing.setFullName(visitor.getFullName());
        existing.setEmail(visitor.getEmail());
        existing.setPhone(visitor.getPhone());
        existing.setIdProofNumber(visitor.getIdProofNumber());
        return visitorRepository.save(existing);
    }

    @Override
    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }
}
