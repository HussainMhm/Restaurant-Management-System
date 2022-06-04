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

    public void addFood(){
        if (foodName.getText().equals("") || foodPrice.getText().equals("") || foodCategory.getText().equals("")){
            Load.errorAlert("Fields cannot be empty");
        }

        else if (!Load.isNumeric(foodPrice.getText())){
            Load.errorAlert("Price must be number");
        }

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

    public void navigateBack(ActionEvent event){
        Load.navigate(event, "AdminDashboard.fxml");
    }
}
