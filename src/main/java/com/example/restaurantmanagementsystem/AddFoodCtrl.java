package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddFoodCtrl {
    @FXML
    private TextField foodName;
    @FXML
    private TextField foodPrice;
    @FXML
    private TextField foodCategory;
    @FXML
    private Button addFoodBtn;
    // something to upload image
    // ...

    public void addFood(){
        System.out.println("Food is added");
    }
}
