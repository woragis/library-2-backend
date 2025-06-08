package com.example.library.domain.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> findById(UUID id);

    List<Book> findAll();

    void deleteById(UUID id);
}
