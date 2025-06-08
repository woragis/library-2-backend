package com.example.library.infrastructure.physicalcopy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.library.domain.physicalcopy.PhysicalCopy;
import com.example.library.domain.physicalcopy.PhysicalCopyRepository;

@Repository
public class PhysicalCopyRepositoryImpl implements PhysicalCopyRepository {

    private final PhysicalCopyJpaRepository jpaRepository;

    public PhysicalCopyRepositoryImpl(PhysicalCopyJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PhysicalCopy save(PhysicalCopy copy) {
        return jpaRepository.save(copy);
    }

    @Override
    public Optional<PhysicalCopy> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<PhysicalCopy> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
