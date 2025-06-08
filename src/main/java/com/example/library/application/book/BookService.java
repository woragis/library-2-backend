package com.example.library.application.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.library.domain.book.Book;
import com.example.library.domain.book.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book createBook(String isbn, String title, String description, int physicalCopyCount) {
        Book book = new Book(UUID.randomUUID(), isbn, title, description, physicalCopyCount);
        return repository.save(book);
    }

    public Optional<Book> getBook(UUID id) {
        return repository.findById(id);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book updateBook(UUID id, String title, String description, int physicalCopyCount) {
        Book book = repository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setDescription(description);
        book.setPhysicalCopyCount(physicalCopyCount);
        return repository.save(book);
    }

    public void deleteBook(UUID id) {
        repository.deleteById(id);
    }
}
