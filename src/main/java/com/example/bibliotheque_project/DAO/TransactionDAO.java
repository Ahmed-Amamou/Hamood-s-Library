/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;

import com.example.bibliotheque_project.Models.Transaction;

import java.util.List;

public interface TransactionDAO {
    boolean addTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByReader(String readerId);
    List<Transaction> getTransactionsByBook(String bookISBN);
    boolean hasBorrowedBook(String readerId, String bookISBN);

    int getTransactionCount();
}