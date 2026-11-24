package com.example;

import java.util.Objects;

public class BookManager {
    private final BookDatabase database;

    public BookManager(BookDatabase database) {
        this.database = Objects.requireNonNull(database, "database cannot be null");
    }

    public void addBook(Book book) {
        database.addBook(book);
    }

    public void updateStatus(Book book, String status) {
        Objects.requireNonNull(book, "book cannot be null");
        book.setActivityStatus(status);
    }
}
