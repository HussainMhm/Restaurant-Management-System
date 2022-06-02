package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminDashboardCtrl {
    @FXML
    private Button orderPage;
    @FXML
    private Button newFoodPage;
    @FXML
    private Button customerScreenPage;

    public void navigateOrderPage(){
        System.out.println("YOU ARE ON ORDER PAGE NOW!");
    }

    public void navigateFoodPage(){
        System.out.println("YOU ARE ON FOOD PAGE NOW!");
    }

    public void navigateCustomerPage(){
        System.out.println("YOU ARE ON CUSTOMER PAGE NOW!");
    }
}
