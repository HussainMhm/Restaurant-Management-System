package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminDashboardCtrl {
    @FXML
    private Button orderPage;
    @FXML
    private Button newFoodPage;
    @FXML
    private Button customerScreenPage;

    public void navigateOrderPage(ActionEvent event){
        System.out.println("YOU ARE ON ORDER PAGE NOW!");
        Initialize.navigate(event, "Order.fxml");
    }

    public void navigateFoodPage(ActionEvent event){
        System.out.println("YOU ARE ON FOOD PAGE NOW!");
        Initialize.navigate(event, "AddFood.fxml");
    }

    public void navigateCustomerPage(ActionEvent event){
        System.out.println("YOU ARE ON CUSTOMER PAGE NOW!");
        Initialize.navigate(event, "CustomerScreen.fxml");
    }

    public void signOut(ActionEvent event){
        Initialize.navigate(event, "Login.fxml");
    }

}
