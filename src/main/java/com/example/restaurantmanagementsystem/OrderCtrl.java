package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
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

    Alert alert;

    public void order(){
        if (customerName.getText().equals("") || foodChoice.getValue() == null || quantity.getValue() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed");
            alert.setContentText("Choice boxes must be selected");
            alert.showAndWait();
        }
        else {
            for (Food food : foodList) {
                if (Objects.equals(food.getName(), foodChoice.getValue())){
                    total.setText(String.valueOf(food.getPrice() * quantity.getValue()));

                    Order newOrder = new Order(customerName.getText());
                    orderList.add(newOrder);
                }
            }
        }
    }

    public void back(ActionEvent event){
        Initialize.navigate(event, "AdminDashboard.fxml");
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
