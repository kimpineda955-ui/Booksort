package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Book {
    public static final String CURRENTLY_READING = "Currently Reading";
    public static final String WANT_TO_READ = "Want to Read";
    public static final String COMPLETED = "Completed";
    public static final String ON_HOLD = "On Hold";
    public static final String ABANDONED = "Abandoned";

    private static final List<String> ACTIVITY_STATUSES = Collections.unmodifiableList(
            Arrays.asList(CURRENTLY_READING, WANT_TO_READ, COMPLETED, ON_HOLD, ABANDONED));

    private String title;
    private String author;
    private String activityStatus;

    public Book(String title, String author, String activityStatus) {
        setTitle(title);
        setAuthor(author);
        setActivityStatus(activityStatus);
    }

    public Book(String title, String author) {
        this(title, author, WANT_TO_READ);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = requireText(title, "title");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = requireText(author, "author");
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        validateActivityStatus(activityStatus);
        this.activityStatus = activityStatus;
    }

    static List<String> getActivityStatuses() {
        return ACTIVITY_STATUSES;
    }

    static void validateActivityStatus(String status) {
        if (!ACTIVITY_STATUSES.contains(status)) {
            throw new IllegalArgumentException(
                    "Activity status must be one of: " + String.join(", ", ACTIVITY_STATUSES));
        }
    }

    private static String requireText(String value, String fieldName) {
        Objects.requireNonNull(value, fieldName + " cannot be null");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank");
        }
        return value;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " [" + activityStatus + "]";
    }
}
