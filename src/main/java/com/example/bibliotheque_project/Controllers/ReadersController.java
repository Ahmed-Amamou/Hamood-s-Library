/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.Controllers;

import com.example.bibliotheque_project.DAO.MySQLReaderDAO;
import com.example.bibliotheque_project.HelloApplication;
import com.example.bibliotheque_project.Models.Reader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ReadersController {

    @FXML
    private TableView<Reader> readerTableView;

    @FXML
    private TableColumn<Reader, Number> idColumn;

    @FXML
    private TableColumn<Reader, String> firstNameColumn;

    @FXML
    private TableColumn<Reader, String> lastNameColumn;

    @FXML
    private TableColumn<Reader, String> emailColumn;
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    private final MySQLReaderDAO readerDAO = new MySQLReaderDAO();
    @FXML
    public void handleAddReader() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        Reader reader = new Reader(0,firstName, lastName, email);
        if(readerDAO.readerExists(email)) {
            readerDAO.showAlert("Reader with the same email already exists", Alert.AlertType.ERROR);
            return;
             }
        else {
            readerDAO.insertReader(reader);
            loadReaders();
        }




    }

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        loadReaders();
    }

    private void loadReaders() {
        List<Reader> readers = readerDAO.findAllReaders();
        readerTableView.getItems().setAll(readers);
    }

    @FXML
    void switchBooksScene(MouseEvent event) {
        System.out.println("Switching to Book scene");
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


}
