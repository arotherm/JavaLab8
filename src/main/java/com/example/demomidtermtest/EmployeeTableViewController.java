package com.example.demomidtermtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmployeeTableViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}