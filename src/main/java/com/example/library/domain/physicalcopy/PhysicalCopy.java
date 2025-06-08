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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public CopyStatus getStatus() {
        return status;
    }

    public void setStatus(CopyStatus status) {
        this.status = status;
    }

    public UUID getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(UUID currentOwner) {
        this.currentOwner = currentOwner;
    }

    // Getters and setters omitted for brevity
}
