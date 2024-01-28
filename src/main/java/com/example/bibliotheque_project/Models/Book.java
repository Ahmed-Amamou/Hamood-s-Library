package com.example.bibliotheque_project.Models;

import javafx.beans.property.*;

public class Book {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty author = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty ISBN = new SimpleStringProperty();
    private final IntegerProperty copiesAvailable = new SimpleIntegerProperty();

    public Book(int id, String title, String author, String ISBN, int copiesAvailable) {
        this.id.set(id);
        this.author.set(author);
        this.title.set(title);
        this.ISBN.set(ISBN);
        this.copiesAvailable.set(copiesAvailable);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getISBN() {
        return ISBN.get();
    }

    public StringProperty ISBNProperty() {
        return ISBN;
    }

    public int getCopiesAvailable() {
        return copiesAvailable.get();
    }

    public IntegerProperty copiesAvailableProperty() {
        return copiesAvailable;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable.set(copiesAvailable);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id.get() +
                ", author='" + author.get() + '\'' +
                ", title='" + title.get() + '\'' +
                ", ISBN=" + ISBN.get() +
                ", copiesAvailable=" + copiesAvailable.get() +
                '}';
    }
}
