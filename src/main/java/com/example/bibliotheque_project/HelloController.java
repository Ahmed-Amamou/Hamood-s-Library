/*
 * Copyright (c) 2023. Bro This is my work please don't steal lol.
 */

package com.example.bibliotheque_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label testText;

    @FXML
    protected void onSecondButtonClick() {
        testText.setText("You Clicked the test button!");
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Mahmoud nab effectivement!");
    }

}