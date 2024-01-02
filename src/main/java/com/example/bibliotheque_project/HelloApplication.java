/*
 * Copyright (c) 2023. Bro This is my work please don't steal lol.
 */

package com.example.bibliotheque_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720,Color.BLACK);
        primaryStage.setTitle("Minecraft");
        primaryStage.setScene(scene);

        //I want to give this window an icon
//        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.getFullScreenExitHint();
//        I want to give this window an icon
        primaryStage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/example/bibliotheque_project/images/pain.png"));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}