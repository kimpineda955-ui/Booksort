package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CategoryManager {
    private Map<String, List<Book>> booksByStatus = createEmptyGroups();

    public Map<String, List<Book>> groupByStatus(List<Book> books) {
        Objects.requireNonNull(books, "books cannot be null");
        Map<String, List<Book>> groupedBooks = createEmptyGroups();
        for (Book book : books) {
            Objects.requireNonNull(book, "books cannot contain null");
            groupedBooks.get(book.getActivityStatus()).add(book);
        }
        booksByStatus = groupedBooks;
        return copyGroups(groupedBooks);
    }

    public List<Book> getBooksByStatus(String status) {
        Book.validateActivityStatus(status);
        return new ArrayList<>(booksByStatus.get(status));
    }

    private static Map<String, List<Book>> createEmptyGroups() {
        Map<String, List<Book>> groups = new LinkedHashMap<>();
        for (String status : Book.getActivityStatuses()) {
            groups.put(status, new ArrayList<>());
        }
        return groups;
    }

    private static Map<String, List<Book>> copyGroups(Map<String, List<Book>> groups) {
        Map<String, List<Book>> copy = new LinkedHashMap<>();
        for (Map.Entry<String, List<Book>> entry : groups.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
}
