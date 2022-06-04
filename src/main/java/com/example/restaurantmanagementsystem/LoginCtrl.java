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

    public void onEnter(ActionEvent ae){
        loginBtn.fire();
    }

    public void navigateAdminDashboard(ActionEvent event) throws IOException {
        if (username.getText().equals("admin") && password.getText().equals("admin"))
            Load.navigate(event, "AdminDashboard.fxml");

        else if (username.getText().equals("") && password.getText().equals(""))
            Load.errorAlert("Fields cannot be empty");

        else
            Load.errorAlert("Username or password invalid");
    }
}