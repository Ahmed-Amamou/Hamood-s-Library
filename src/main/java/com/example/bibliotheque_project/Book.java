
/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project;

public class Book {
    private int id;
    private String author;
    private String title;
    private int ISBN;
    private int copiesAvailable;

    public Book(int id, String title, String author,  int ISBN,int copiesAvailable) {

        this.id = id;
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.copiesAvailable = copiesAvailable;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getCopies() {
        return copiesAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", copiesAvailable=" + copiesAvailable +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }
}
