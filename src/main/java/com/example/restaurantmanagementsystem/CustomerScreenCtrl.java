package com.example.restaurantmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;


public class CustomerScreenCtrl implements Initializable {
    @FXML
    private Button backBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Button galleryBtn;
    @FXML
    private TableView<String> orderQueueTable;

    @FXML
    private TableView<Food> mealsStackTable;

    Stack stack = new Stack();
    public void addFoodToStack(){
        for (Food food : foodList){
            stack.push(food);
            System.out.println(stack.getSize());
        }

    }

    ObservableList<Food> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Food, String> foodNameColumn;
    @FXML
    private TableColumn<Food, Float> foodPriceColumn;


    public void navigateMenuPage(ActionEvent event){
        Initialize.navigate(event, "Menu.fxml");
    }

    public void navigateGalleryPage(ActionEvent event){
        Initialize.navigate(event, "Gallery.fxml");
    }

    public void back(ActionEvent event){
        Initialize.navigate(event, "AdminDashboard.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addFoodToStack();
        int stackSize = stack.getSize();
        for (int i = 0; i < stackSize; i++){
            list.add(stack.pop());
        }

        foodNameColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        foodPriceColumn.setCellValueFactory(new PropertyValueFactory<Food, Float>("price"));

        mealsStackTable.setItems(list);
    }
}
