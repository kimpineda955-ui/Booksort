package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BookDatabase {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(Objects.requireNonNull(book, "book cannot be null"));
    }

    public Book findBook(String title) {
        Objects.requireNonNull(title, "title cannot be null");
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(new ArrayList<>(books));
    }
}
