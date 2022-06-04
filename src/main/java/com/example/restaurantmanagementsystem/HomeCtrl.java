package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeCtrl {
    @FXML
    private Button launchBtn;

    public void navigateLogin(ActionEvent event) throws IOException {
        Load.navigate(event, "Login.fxml");
    }
}