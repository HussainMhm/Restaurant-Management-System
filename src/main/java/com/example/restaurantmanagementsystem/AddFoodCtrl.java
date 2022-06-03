package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

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
    // something to upload image
    // ...
    @FXML
    private Button backBtn;

    Alert alert;

    public void addFood(){
        if (Objects.equals(foodName.getText(), "") || Objects.equals(foodPrice.getText(), "" ) || Objects.equals(foodCategory.getText(), "")){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed");
            alert.setContentText("Fields cannot be empty");
            alert.showAndWait();
        }
        else if (!Initialize.isNumeric(foodPrice.getText())){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed");
            alert.setContentText("Price must be number");
            alert.showAndWait();
        }
        else {
            String name = foodName.getText();
            String category = foodCategory.getText();
            float price = Float.parseFloat(foodPrice.getText());

            Food newFood = new Food(name, category, price);
            foodList.add(newFood);

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Food is added");
            alert.setContentText(
                    "Name: " + name +
                            "\nPrice: " + price+
                            "\nCategory: " + category);
            alert.showAndWait();
        }
    }

    public void back(ActionEvent event){
        Initialize.navigate(event, "AdminDashboard.fxml");
    }


}
