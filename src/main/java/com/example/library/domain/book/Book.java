package com.example.library.domain.book;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    private UUID id;

    private String isbn;
    private String title;
    private String description;
    private int physicalCopyCount;
    private int likeCount;
    private int commentCount;
    private int borrowCount;

    protected Book() {
    } // JPA

    public Book(UUID id, String isbn, String title, String description, int physicalCopyCount) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.physicalCopyCount = physicalCopyCount;
        this.likeCount = 0;
        this.commentCount = 0;
        this.borrowCount = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhysicalCopyCount() {
        return physicalCopyCount;
    }

    public void setPhysicalCopyCount(int physicalCopyCount) {
        this.physicalCopyCount = physicalCopyCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    // Getters and setters omitted for brevity

    // Optional: domain methods (incrementLikes, addComment, etc.)
}
