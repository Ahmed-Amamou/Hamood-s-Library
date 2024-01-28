/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;

import com.example.bibliotheque_project.Models.Reader;
import com.example.bibliotheque_project.Connections.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLReaderDAO implements ReaderDAO{
    private final Connection connection = MySQLConnection.getConnection();
    @Override
    public Reader findReaderById(int id) {
        Reader reader = null;
        String query = "SELECT * FROM reader WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                reader = new Reader(id, firstName, lastName, email);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return reader;

    }

    @Override
    public List<Reader> findAllReaders() {
        List<Reader> readers = new ArrayList<>(); // Initialize the list
        String query = "SELECT * FROM reader";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                readers.add(new Reader(id, firstName, lastName, email));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }


    @Override
    public void insertReader(Reader reader) {
        String query = "INSERT INTO reader (firstName, lastName, email) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, reader.getFirstName());
            preparedStatement.setString(2, reader.getLastName());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    Reminder for myself:
    //Question: when I have id on auto increment in database, do I need to put it in the query ?
    //Answer: No, you don't need to put it in the query

    @Override
    public void updateReader(Reader reader) {
        String query = "UPDATE reader SET firstName = ?, lastName = ?, email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, reader.getFirstName());
            preparedStatement.setString(2, reader.getLastName());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setInt(4, reader.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReader(int id) {
        String query = "DELETE FROM reader WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
