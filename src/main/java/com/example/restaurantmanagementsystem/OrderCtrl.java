package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;
import static com.example.restaurantmanagementsystem.Kitchen.orderList;


public class OrderCtrl implements Initializable {
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

    // Make order function
    public void order(){
        // Check if any field is empty
        if (customerName.getText().equals("") || foodChoice.getValue() == null || quantity.getValue() == null){
            Load.errorAlert("You Didn't Make A Choice.");
        }
        // If all fields are filled
        else {
            for (Food food : foodList) {
                // Calculate the price
                if (food.getName().equals(foodChoice.getValue())){
                    total.setText(String.valueOf(food.getPrice() * quantity.getValue()) + " TL");

                // Add to orders and throw success alert
                    Order newOrder = new Order(customerName.getText());
                    orderList.add(newOrder);
                    Load.infoAlert("Order placed successfully", "");
                }
            }
        }
    }

    public void navigateBack(ActionEvent event){
        Load.navigate(event, "AdminDashboard.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Food food : foodList)
            foodChoice.getItems().add(food.getName());

        int[] nums = {1, 2, 3, 4 ,5};
        for (int num : nums)
            quantity.getItems().add(num);
    }
}
