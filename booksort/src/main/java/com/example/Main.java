package com.example;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BookDatabase database = new BookDatabase();
        BookManager manager = new BookManager(database);

        Book dune = new Book("Dune", "Frank Herbert", Book.WANT_TO_READ);
        Book prideAndPrejudice = new Book(
                "Pride and Prejudice", "Jane Austen", Book.COMPLETED);
        Book theHobbit = new Book(
                "The Hobbit", "J.R.R. Tolkien", Book.CURRENTLY_READING);
        Book neuromancer = new Book(
                "Neuromancer", "William Gibson", Book.ON_HOLD);
        Book kindred = new Book(
                "Kindred", "Octavia E. Butler", Book.ABANDONED);

        manager.addBook(dune);
        manager.addBook(prideAndPrejudice);
        manager.addBook(theHobbit);
        manager.addBook(neuromancer);
        manager.addBook(kindred);
        manager.updateStatus(dune, Book.CURRENTLY_READING);

        System.out.println("All books:");
        printBooks(database.getAllBooks());

        BookSorter sorter = new BookSorter();
        System.out.println("\nBooks sorted by title:");
        printBooks(sorter.sortByTitle(database.getAllBooks()));

        System.out.println("\nBooks sorted by author:");
        printBooks(sorter.sortByAuthor(database.getAllBooks()));

        System.out.println("\nBooks sorted by activity status:");
        printBooks(sorter.sortByStatus(database.getAllBooks()));

        CategoryManager categoryManager = new CategoryManager();
        Map<String, List<Book>> booksByStatus =
                categoryManager.groupByStatus(database.getAllBooks());
        System.out.println("\nBooks grouped by activity status:");
        for (Map.Entry<String, List<Book>> category : booksByStatus.entrySet()) {
            System.out.println(category.getKey() + ":");
            printBooks(category.getValue());
        }

        System.out.println("\nSearching for Dune:");
        Book foundBook = database.findBook("Dune");
        System.out.println(foundBook == null ? "Book not found." : foundBook);
    }

    private static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
