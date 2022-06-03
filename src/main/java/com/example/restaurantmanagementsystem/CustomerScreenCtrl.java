package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CustomerScreenCtrl {
    @FXML
    private Button backBtn;

    public void back(ActionEvent event){
        Initialize.navigate(event, "AdminDashboard.fxml");
    }
}
