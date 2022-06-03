package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginCtrl {

    @FXML
    private TextField username_tf;
    @FXML
    private PasswordField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Alert alert;

    public void navigateAdminDashboard(ActionEvent event) throws IOException {

        if (Objects.equals(username_tf.getText(), "admin") && Objects.equals(passwordField.getText(), "admin")){
            Initialize.navigate(event, "AdminDashboard.fxml");
        }
        else if (Objects.equals(username_tf.getText(), "") && Objects.equals(passwordField.getText(), "")){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed");
            alert.setContentText("Fields cannot be empty");
            alert.showAndWait();
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed");
            alert.setContentText("Username or password invalid");
            alert.showAndWait();
        }
    }
}
