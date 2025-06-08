package com.example.library.web.physicalcopy;

import java.util.UUID;

import com.example.library.domain.physicalcopy.CopyStatus;

public record PhysicalCopyDTO(
        UUID bookId,
        CopyStatus status,
        UUID currentOwner // nullable
) {
}
