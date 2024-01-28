/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;

import com.example.bibliotheque_project.Models.Book;

import java.util.List;

public interface BookDAO  {
    Book findBookById(int id);
    Book findBookByISBN(String ISBN);
    List<Book> findAllBooks();
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    boolean bookExists(String ISBN);
    //the next methods deal with the copies of the book
    void increaseCopies(String bookISBN, int count);
    void decreaseCopies(String bookISBN, int count);


}
