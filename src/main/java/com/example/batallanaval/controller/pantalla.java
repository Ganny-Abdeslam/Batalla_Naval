package com.example.batallanaval.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class pantalla {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}