/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.Controllers;

import com.example.bibliotheque_project.DAO.*;
import com.example.bibliotheque_project.HelloApplication;
import com.example.bibliotheque_project.Models.Book;
import com.example.bibliotheque_project.Models.Reader;
import com.example.bibliotheque_project.Models.Transaction;
import com.example.bibliotheque_project.Models.TransactionType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class LendingController {

    @FXML
    private ChoiceBox<String> actionChoiceBox;

    @FXML
    private TextField readerIdTextField;

    @FXML
    private TextField bookISBNTextField;

    @FXML
    private Button performActionButton;

    private final TransactionDAO transactionDAO = new MySQLTransactionDAO();
    private final BookDAO bookDAO = new MySQLBookDAO();
    @FXML
    private void handlePerformAction() {
        String action = actionChoiceBox.getValue();
        String readerId = readerIdTextField.getText();
        String bookIsbn = bookISBNTextField.getText();

        if (action == null || readerId.isEmpty() || bookIsbn.isEmpty()) {
            // Display an alert or handle invalid input
            System.out.println("Invalid input. Please fill in all fields.");
            return;
        }

        switch (action) {
            case "Borrow":
                handleBorrowAction(readerId, bookIsbn);
                break;
            case "Return":
                handleReturnAction(readerId, bookIsbn);
                break;
            default:
                // Handle unsupported action
                System.out.println("Unsupported action: " + action);
                break;
        }
    }


    private void handleBorrowAction(String readerId, String bookIsbn) {
        // Check if the book has available copies
        Book book = bookDAO.findBookByISBN(bookIsbn);
        if (book == null) {
            // Book not found
            System.out.println("Book not found: " + bookIsbn);
            return;
        }

        if (book.getCopiesAvailable() > 0) {
            // Borrow the book
            Transaction transaction = new Transaction(readerId, bookIsbn, TransactionType.BORROW);
            transactionDAO.addTransaction(transaction);

            // Update available copies in the book
            bookDAO.decreaseCopies(bookIsbn,1);
//            bookDAO.updateBook(book);

//            System.out.println("Book borrowed successfully!");
            showAlert("Book borrowed successfully!", String.valueOf(Alert.AlertType.INFORMATION));
        } else {
            // No available copies
//            System.out.println("No available copies for the book: " + bookIsbn);
            showAlert("No available copies for the book: " + bookIsbn, String.valueOf(Alert.AlertType.WARNING));
        }

    }

    private void handleReturnAction(String readerId, String bookIsbn) {
        // Check if the reader has borrowed the book before
        if (transactionDAO.hasBorrowedBook(readerId, bookIsbn)) {
            // Return the book
            Transaction transaction = new Transaction(readerId, bookIsbn, TransactionType.RETURN);
            transactionDAO.addTransaction(transaction);

            // Update available copies in the book
            Book book = bookDAO.findBookByISBN(bookIsbn);
            bookDAO.increaseCopies(bookIsbn, 1);
//            bookDAO.updateBook(book);

//            System.out.println("Book returned successfully!");
            showAlert("Book returned successfully!", String.valueOf(Alert.AlertType.INFORMATION));
        } else {
            // Reader has not borrowed the book
//            System.out.println("Reader has not borrowed the book: " + bookIsbn);
            showAlert("Reader has not borrowed the book: " + bookIsbn, String.valueOf(Alert.AlertType.WARNING));
        }
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
    private void initialize() {
        // Populate the choice boxes with data
//        populateReaderChoiceBox();
//        populateBookChoiceBox();
//        actionChoiceBox.getItems().addAll("Borrow", "Return");
        // Set up event handler for the action button
//        performActionButton.setOnAction(event -> handlePerformAction());
    }
    @FXML
    void switchBooksScene(MouseEvent event) {
        System.out.println("Switching to books scene");
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Views/Books.fxml"));
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Books.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/book.png"));
            stage.setResizable(false);
            stage.setTitle("Hamood's Library");
            // Show the new stage
            stage.show();

            // Close the current stage (optional)
            ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
    @FXML
    void switchHomeScene(MouseEvent event) {
        System.out.println("Switching to Home scene");
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Views/Home.fxml"));
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Books.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/book.png"));
            stage.setResizable(false);
            stage.setTitle("Hamood's Library");
            // Show the new stage
            stage.show();

            // Close the current stage (optional)
            ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
    @FXML
    void switchReadersScene(MouseEvent event) {
        System.out.println("Switching to Readers scene");
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Views/Readers.fxml"));
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Books.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/book.png"));
            stage.setResizable(false);
            stage.setTitle("Hamood's Library");
            // Show the new stage
            stage.show();

            // Close the current stage (optional)
            ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
//    private void populateReaderChoiceBox() {
//        if (readerChoiceBox != null) {
//            List<String> readerEmails = readerDAO.getAllReaderEmails();
//            if (readerEmails != null) {
//                readerChoiceBox.getItems().addAll(readerEmails);
//            } else {
//                System.out.println("Reader emails are null.");
//            }
//        } else {
//            System.out.println("readerChoiceBox is null.");
//        }
//    }

//    private void populateBookChoiceBox() {
//        // Implement logic to fetch book titles from the database
//        Map<String, String> bookTitlesAndISBNs = bookDAO.getAllBookTitlesAndISBNs();
//        if (bookTitlesAndISBNs != null) {
//            bookChoiceBox.getItems().addAll(bookTitlesAndISBNs.values());
//        } else {
//            System.out.println("woops");
//        }
//
//    }

}
