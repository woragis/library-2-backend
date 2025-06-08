package com.example.library.infrastructure.book;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domain.book.Book;

public interface BookJpaRepository extends JpaRepository<Book, UUID> {
}
