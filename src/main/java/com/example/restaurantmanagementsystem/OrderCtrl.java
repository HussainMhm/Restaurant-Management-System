package com.example.restaurantmanagementsystem;

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

    public void order(){
        System.out.println("ORDER MADE");
    }
}
