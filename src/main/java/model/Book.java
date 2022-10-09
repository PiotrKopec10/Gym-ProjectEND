package model;

import model.enums.BookType;

import java.time.LocalDate;

public class Book {
    private String title;
    private LocalDate publishDate;
    private BookType bookType;
    private Author author;


    public Book(String title, LocalDate publishDate, BookType bookType, Author author) {
        this.title = title;
        this.publishDate = publishDate;
        this.bookType = bookType;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public BookType getBookType() {
        return bookType;
    }

    public Author getAuthor() {
        return author;
    }
}
