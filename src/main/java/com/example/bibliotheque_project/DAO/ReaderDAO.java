/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;
import com.example.bibliotheque_project.Models.Reader;
import javafx.scene.control.Alert;

import java.util.List;
public interface ReaderDAO {
    Reader findReaderById(int id);

    List<Reader> findAllReaders();

    void insertReader(Reader reader);

    void updateReader(Reader reader);

    void deleteReader(int id);

    boolean readerExists(String email);

    void showAlert(String message, Alert.AlertType alertType);

    Reader getReaderByEmail(String readerEmail);

    List<String> getAllReaderEmails();

    int getReaderCount();
}
