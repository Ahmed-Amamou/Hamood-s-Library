package com.example.bibliotheque_project.Controllers;

import com.example.bibliotheque_project.DAO.*;
import com.example.bibliotheque_project.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {
    @FXML
    private Label totalBooks;

    @FXML
    private Label totalReaders;

    @FXML
    private Label totalTransactions;

    @FXML
    private Text textIN;

    @FXML
    private TextField textOUT;

    @FXML
    void overwrite(MouseEvent event) {
        textIN.setText(textOUT.getText());

    }


    private final BookDAO bookDAO = new MySQLBookDAO();  // Assuming you have a BookDAO instance
    private final ReaderDAO readerDAO=new MySQLReaderDAO();  // Assuming you have a ReaderDAO instance
    private final TransactionDAO transactionDAO = new MySQLTransactionDAO();  // Assuming you have a TransactionDAO instance

//

    public void initialize() {
        updateCounts();
    }

    private void updateCounts() {
        // Fetch counts from the database
        int bookCount = bookDAO.getBookCount();
        int readerCount = readerDAO.getReaderCount();
        int transactionCount = transactionDAO.getTransactionCount();

        // Update labels with counts
        totalBooks.setText(" " + bookCount);
        totalReaders.setText(" " + readerCount);
        totalTransactions.setText(" " + transactionCount);
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

            // Show the new stage
            stage.show();

            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/book.png"));
            stage.setResizable(false);
            stage.setTitle("Hamood's Library");


            // Close the current stage (optional)
            ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
    @FXML
    void switchReadersScene(MouseEvent event) {
        System.out.println("Switching to books scene");
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
    @FXML
    void switchLendingScene(MouseEvent event) {
        System.out.println("Switching to books scene");
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

}
