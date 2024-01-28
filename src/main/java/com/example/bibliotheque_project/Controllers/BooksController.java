/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.Controllers;

import com.example.bibliotheque_project.DAO.BookDAO;
import com.example.bibliotheque_project.DAO.MySQLBookDAO;
import com.example.bibliotheque_project.HelloApplication;
import com.example.bibliotheque_project.Models.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BooksController {
    @FXML
    private TableView<Book> bookTableView;

    @FXML
    private TableColumn<Book, Integer> idColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, Integer> copiesAvailableColumn;
    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField isbnTextField;
    @FXML
    private TextField copiesTextField;


    @FXML
    private void handleAddBook() {
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String isbn = isbnTextField.getText();
        int copies = Integer.parseInt(copiesTextField.getText());

        // Check if the book with the given ISBN already exists
        boolean bookExists = bookDAO.bookExists(isbn);

        if (bookExists) {
            // Update the existing book with increased copies
            bookDAO.increaseCopies(isbn, copies);
        } else {
            // Create a new Book object and add it to the database
            Book newBook = new Book(0, title, author, isbn, copies);
            bookDAO.insertBook(newBook);
        }

        // Optionally, you can close the window or reset the text fields
        titleTextField.clear();
        authorTextField.clear();
        isbnTextField.clear();
        copiesTextField.clear();
        //refresh
        loadBooks();
    }

    private final BookDAO bookDAO = new MySQLBookDAO();
    @FXML
    public void initialize() {
        // Initialize TableView columns
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        isbnColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty());
        copiesAvailableColumn.setCellValueFactory(cellData -> cellData.getValue().copiesAvailableProperty().asObject());
        copiesTextField.setText("1");
        // Load data into TableView
        loadBooks();
    }

    private void loadBooks() {
        List<Book> books = bookDAO.findAllBooks();
        bookTableView.getItems().setAll(books);
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
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/pain.png"));
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
    void switchLendingScene(MouseEvent event) {
        System.out.println("Switching to Lending scene");
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Views/Lending.fxml"));
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Books.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/pain.png"));
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
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/pain.png"));
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



}
