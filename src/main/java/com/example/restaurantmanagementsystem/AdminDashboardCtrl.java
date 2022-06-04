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
        Load.navigate(event, "Order.fxml");
    }

    public void navigateFoodPage(ActionEvent event){
        Load.navigate(event, "AddFood.fxml");
    }

    public void navigateCustomerPage(ActionEvent event){
        Load.navigate(event, "CustomerScreen.fxml");
    }

    public void signOut(ActionEvent event){
        Load.navigate(event, "Login.fxml");
    }
}
