package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class CustomerScreenCtrl {
    @FXML
    private Button backBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Button galleryBtn;
    @FXML
    private TableView<String> orderQueueTable;
    @FXML
    private TableView<String> mealsStackTable;


    public void navigateMenuPage(ActionEvent event){
        Initialize.navigate(event, "Menu.fxml");
    }

    public void navigateGalleryPage(ActionEvent event){
        Initialize.navigate(event, "Gallery.fxml");
    }

    public void back(ActionEvent event){
        Initialize.navigate(event, "AdminDashboard.fxml");
    }
}
