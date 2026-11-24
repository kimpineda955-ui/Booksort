package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BookSorter {
    public List<Book> sortByTitle(List<Book> books) {
        return sortedCopy(books, Comparator.comparing(
                Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Book> sortByAuthor(List<Book> books) {
        return sortedCopy(books, Comparator.comparing(
                Book::getAuthor, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Book> sortByStatus(List<Book> books) {
        return sortedCopy(books, Comparator.comparing(
                Book::getActivityStatus, String.CASE_INSENSITIVE_ORDER));
    }

    private static List<Book> sortedCopy(List<Book> books, Comparator<Book> comparator) {
        Objects.requireNonNull(books, "books cannot be null");
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(comparator);
        return sortedBooks;
    }
}
