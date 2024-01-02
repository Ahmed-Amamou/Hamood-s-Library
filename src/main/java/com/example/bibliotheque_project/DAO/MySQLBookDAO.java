/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;
import com.example.bibliotheque_project.Book;
import com.example.bibliotheque_project.Connections.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLBookDAO implements BookDAO{
    private Connection connection = MySQLConnection.getConnection();
    @Override
    public Book findBookById(int id) {
        Book book = null;
        String query = "SELECT * FROM book WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int ISBN = resultSet.getInt("ISBN");
                int copies = resultSet.getInt("copies");
                book = new Book(id, author, title,  ISBN, copies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int ISBN = resultSet.getInt("ISBN");
                int copies = resultSet.getInt("copies");
                books.add(new Book(id, title, author, ISBN, copies));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;

    }

    @Override
    public void insertBook(Book book) {
        // if book already exists, increase the number of copies
        // else insert the book
        //Document that I made this choice because I don't want to have two books with the same id
        //and when we insert a book we don't know if it exists or not
        //Q:argument that id and isbn here are the same ?
        //A:two books with the same title and author don't always have the same ISBN
        Book book1 = findBookById(book.getId());
        if(book1 != null){
            increaseCopies(book.getId(), book.getCopies());
        }else{
            String query = "INSERT INTO book (id, title, author, ISBN, copies) VALUES (?, ?, ?, ?, ?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1, book.getId());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setString(3, book.getAuthor());
                preparedStatement.setInt(4, book.getISBN());
                preparedStatement.setInt(5, book.getCopies());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateBook(Book book) {
        String query = "UPDATE book SET title = ?, author = ?, ISBN = ?, copies = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getISBN());
            preparedStatement.setInt(4, book.getCopies());
            preparedStatement.setInt(5, book.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteBook(int id) {

        String query = "DELETE FROM book WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void increaseCopies(int bookId, int count) {
        String query = "UPDATE Book SET copies_available = copies_available + ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, count);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
    }

    @Override
    public void decreaseCopies(int bookId, int count) {
        String query = "UPDATE Book SET copies_available = GREATEST(copies_available - ?, 0) WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, count);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
    }
}
