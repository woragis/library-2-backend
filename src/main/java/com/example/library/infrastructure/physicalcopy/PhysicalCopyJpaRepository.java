package com.example.library.infrastructure.physicalcopy;

import com.example.library.domain.physicalcopy.PhysicalCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PhysicalCopyJpaRepository extends JpaRepository<PhysicalCopy, UUID> {
}
