package com.example.library.domain.physicalcopy;

import java.util.*;

public interface PhysicalCopyRepository {
    PhysicalCopy save(PhysicalCopy copy);

    Optional<PhysicalCopy> findById(UUID id);

    List<PhysicalCopy> findAll();

    void deleteById(UUID id);
}
