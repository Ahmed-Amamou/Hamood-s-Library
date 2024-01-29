/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.Models;

import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private String readerId;
    private String bookISBN;
    private TransactionType transactionType;
    private LocalDateTime transactionDateTime;

    public Transaction(String readerId, String bookISBN, TransactionType transactionType) {
        this.readerId = readerId;
        this.bookISBN = bookISBN;
        this.transactionType = transactionType;
        this.transactionDateTime = LocalDateTime.now();
    }


    public int getId() {
        return id;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    // Add setters if necessary

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", readerId='" + readerId + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", transactionType=" + transactionType +
                ", transactionDateTime=" + transactionDateTime +
                '}';
    }

    public void setId(int anInt) {
        this.id = anInt;
    }
}
