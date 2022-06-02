package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
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
    // something to upload image
    // ...

    public void addFood(){
        System.out.println("Food is added");

        String name = foodName.getText();
        String category = foodCategory.getText();
        int price = Integer.parseInt(foodPrice.getText());

        Food newFood = new Food(name, category, price);
        foodList.add(newFood);

//        System.out.println(foodList.get(1).getName());
//        System.out.println(foodList.get(1).getPrice());
//        System.out.println(foodList.get(1).getCategory());
    }
}
