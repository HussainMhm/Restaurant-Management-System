package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class OrderCtrl {
    @FXML
    private TextField customerName;
    @FXML
    private ChoiceBox<String> foodChoice;
    @FXML
    private ChoiceBox<Integer> quantity;
    @FXML
    private Button orderBtn;
    @FXML
    private TextField total;
    @FXML
    private Button backBtn;

    public void order(){
        System.out.println("ORDER MADE");
    }

    public void back(ActionEvent event){
        Initialize.navigate(event, "AdminDashboard.fxml");
    }
}
