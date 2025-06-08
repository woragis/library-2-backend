package com.example.library.infrastructure.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.library.domain.book.Book;
import com.example.library.domain.book.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository jpaRepository;

    public BookRepositoryImpl(BookJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Book save(Book book) {
        return jpaRepository.save(book);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
