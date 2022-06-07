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
import static com.example.restaurantmanagementsystem.Kitchen.orderList;

public class CustomerScreenCtrl implements Initializable {
    @FXML
    private Button backBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Button galleryBtn;
    @FXML
    private TableView<Order> orderQueueTable;
    @FXML
    private TableColumn<Order, String> peopleOrdersColumn;
    @FXML
    private TableView<Food> mealsStackTable;
    @FXML
    private TableColumn<Food, String> foodNameColumn;
    @FXML
    private TableColumn<Food, Float> foodPriceColumn;

    // Stack for new added meals
    Stack stack = new Stack();
    ObservableList<Food> stackList = FXCollections.observableArrayList();

    // Push meals from (Kitchen) foodList to Stack
    public void addFoodToStack(){
        for (Food food : foodList)
            stack.push(food);

        int stackSize = stack.getSize();
        for (int i = 0; i < stackSize; i++)
            stackList.add(stack.pop());
    }

    // Stack for customer orders
    Queue queue = new Queue();
    ObservableList<Order> queueList = FXCollections.observableArrayList();

    BinaryTree tree = new BinaryTree();
    public void addPriceToTree(){
        for (Food food : foodList)
            tree.insert((int) food.getPrice());
    }

    public void printPrices(){
        tree.traverseInOrder();
    }

    // Enqueue orders from (Kitchen) orderList to Queue
    public void addOrdersToQueue(){
        for (Order order : orderList){
            queue.enqueue(order);
            queueList.add(queue.dequeue());
        }
    }

    // Displaying data in tableView's
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addFoodToStack();
        addOrdersToQueue();

        foodNameColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        foodPriceColumn.setCellValueFactory(new PropertyValueFactory<Food, Float>("price"));
        peopleOrdersColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("customer"));

        mealsStackTable.setItems(stackList);
        orderQueueTable.setItems(queueList);
    }

    // Navigation functions to other pages
    public void navigateMenuPage(ActionEvent event){
        Load.navigate(event, "Menu.fxml");
    }

    public void navigateGalleryPage(ActionEvent event){
        Load.navigate(event, "Gallery.fxml");
    }

    public void navigateBack(ActionEvent event){
        Load.navigate(event, "AdminDashboard.fxml");
    }
}