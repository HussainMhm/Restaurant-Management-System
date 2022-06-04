package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuCtrl {
    @FXML
    private Button backBtn;

    public void back(ActionEvent event){
        Load.navigate(event, "CustomerScreen.fxml");
    }
}
