package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginCtrl {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginBtn;

    // Login by pressing Enter Key
    public void onEnter(ActionEvent ae){
        loginBtn.fire();
    }

    // Access to admin dashboard
    public void navigateAdminDashboard(ActionEvent event) throws IOException {
        // Check username and password
        if (username.getText().equals("admin") && password.getText().equals("admin"))
            Load.navigate(event, "AdminDashboard.fxml");

        // Check if any field is empty
        else if (username.getText().equals("") && password.getText().equals(""))
            Load.errorAlert("Fields cannot be empty");

        // In case password isn't correct throw an error alert
        else
            Load.errorAlert("Username or password invalid");
    }
}