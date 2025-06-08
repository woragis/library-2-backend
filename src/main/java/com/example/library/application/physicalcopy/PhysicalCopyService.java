package com.example.library.application.physicalcopy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.library.domain.physicalcopy.CopyStatus;
import com.example.library.domain.physicalcopy.PhysicalCopy;
import com.example.library.domain.physicalcopy.PhysicalCopyRepository;

@Service
public class PhysicalCopyService {

    private final PhysicalCopyRepository repository;

    public PhysicalCopyService(PhysicalCopyRepository repository) {
        this.repository = repository;
    }

    public PhysicalCopy create(UUID bookId, CopyStatus status, UUID currentOwner) {
        PhysicalCopy copy = new PhysicalCopy(UUID.randomUUID(), bookId, status);
        copy.setCurrentOwner(currentOwner);
        return repository.save(copy);
    }

    public Optional<PhysicalCopy> getById(UUID id) {
        return repository.findById(id);
    }

    public List<PhysicalCopy> getAll() {
        return repository.findAll();
    }

    public PhysicalCopy update(UUID id, CopyStatus status, UUID currentOwner) {
        PhysicalCopy copy = repository.findById(id).orElseThrow();
        copy.setStatus(status);
        copy.setCurrentOwner(currentOwner);
        return repository.save(copy);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
