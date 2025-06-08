package com.example.library.domain.physicalcopy;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class PhysicalCopy {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID bookId;

    @Enumerated(EnumType.STRING)
    private CopyStatus status;

    private UUID currentOwner; // nullable

    protected PhysicalCopy() {
    }

    public PhysicalCopy(UUID id, UUID bookId, CopyStatus status) {
        this.id = id;
        this.bookId = bookId;
        this.status = status;
    }

    // Getters and setters omitted for brevity
}
