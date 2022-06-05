package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;

public class AddFoodCtrl {
    @FXML
    private TextField foodName;
    @FXML
    private TextField foodCategory;
    @FXML
    private TextField foodPrice;
    @FXML
    private Button addFoodBtn;
    @FXML
    private Button backBtn;

    Alert alert;

// Function that adds new meals to the kitchen
    public void addFood(){
        // Check for empty fields
        if (foodName.getText().equals("") || foodPrice.getText().equals("") || foodCategory.getText().equals("")){
            Load.errorAlert("Fields cannot be empty");
        }
        // Check if price is a number
        else if (!Load.isNumeric(foodPrice.getText())){
            Load.errorAlert("Price must be number");
        }
        // Take input and add new meal
        else {
            String name = foodName.getText();
            String category = foodCategory.getText();
            float price = Float.parseFloat(foodPrice.getText());

            Food newFood = new Food(name, category, price);
            foodList.add(newFood);

            Load.infoAlert("Food is added",
                    "Name: " + name +
                    "\nPrice: " + price+
                    "\nCategory: " + category);
        }
    }
// Navigate to previous page
    public void navigateBack(ActionEvent event){
        Load.navigate(event, "AdminDashboard.fxml");
    }
}
