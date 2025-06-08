package com.example.library.web.book;

public record BookDTO(
        String isbn,
        String title,
        String description,
        int physicalCopyCount) {
}
