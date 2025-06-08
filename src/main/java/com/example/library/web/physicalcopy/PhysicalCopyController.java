package com.example.library.web.physicalcopy;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.application.physicalcopy.PhysicalCopyService;
import com.example.library.domain.physicalcopy.PhysicalCopy;

@RestController
@RequestMapping("/physical-copies")
public class PhysicalCopyController {

    private final PhysicalCopyService service;

    public PhysicalCopyController(PhysicalCopyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PhysicalCopy> create(@RequestBody PhysicalCopyDTO dto) {
        PhysicalCopy copy = service.create(dto.bookId(), dto.status(), dto.currentOwner());
        return ResponseEntity.ok(copy);
    }

    @GetMapping
    public ResponseEntity<List<PhysicalCopy>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhysicalCopy> get(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhysicalCopy> update(@PathVariable UUID id, @RequestBody PhysicalCopyDTO dto) {
        PhysicalCopy updated = service.update(id, dto.status(), dto.currentOwner());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
