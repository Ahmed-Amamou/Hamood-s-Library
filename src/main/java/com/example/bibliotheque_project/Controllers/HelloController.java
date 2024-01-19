/*
 * Copyright (c) 2023-2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.Controllers;

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
    protected void onMahmoudButtonClick() {
        welcomeText.setText("Mahmoud nab effectivement!");
    }

}