/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.DAO;
import com.example.bibliotheque_project.Models.Reader;
import java.util.List;
public interface ReaderDAO {
    Reader findReaderById(int id);
    List<Reader> findAllReaders();
    void insertReader(Reader reader);
    void updateReader(Reader reader);
    void deleteReader(int id);

}
