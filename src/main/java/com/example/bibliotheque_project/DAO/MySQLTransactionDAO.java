/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;

import com.example.bibliotheque_project.Connections.MySQLConnection;
import com.example.bibliotheque_project.Models.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTransactionDAO implements TransactionDAO {

    private Connection connection = MySQLConnection.getConnection();
    @Override
    public boolean hasBorrowedBook(String readerId, String bookISBN) {
        String query = "SELECT COUNT(*) FROM transactions " +
                "WHERE reader_id = ? AND book_isbn = ? AND transaction_type = 'BORROW'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, readerId);
            preparedStatement.setString(2, bookISBN);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public int getTransactionCount() {
        String query = "SELECT COUNT(*) FROM transactions";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if an error occurs
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (reader_id, book_isbn, transaction_type, transaction_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, transaction.getReaderId());
            preparedStatement.setString(2, transaction.getBookISBN());
            preparedStatement.setString(3, transaction.getTransactionType().name());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(transaction.getTransactionDateTime()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    transaction.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        // Implement logic to retrieve all transactions from the database
        // and convert them to a list of Transaction objects
        return new ArrayList<>();
    }

    @Override
    public List<Transaction> getTransactionsByReader(String readerId) {
        // Implement logic to retrieve transactions by reader ID from the database
        // and convert them to a list of Transaction objects
        return new ArrayList<>();
    }

    @Override
    public List<Transaction> getTransactionsByBook(String bookISBN) {
        // Implement logic to retrieve transactions by book ISBN from the database
        // and convert them to a list of Transaction objects
        return new ArrayList<>();
    }
}