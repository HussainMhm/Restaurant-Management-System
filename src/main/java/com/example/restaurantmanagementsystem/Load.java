package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;
import static com.example.restaurantmanagementsystem.GalleryCtrl.pathList;

public class Load {
    // Function to load some random food and images for demo
    public static void initializeData(){
        foodList.add(new Food("Kabsa", "Arabic", 60));
        foodList.add(new Food("Shawarma", "Arabic", 20));
        foodList.add(new Food("Pizza", "Italian", 30));
        foodList.add(new Food("Burger", "American", 40));
        foodList.add(new Food("Kebap", "Turkish", 50));
        foodList.add(new Food("Çiğ Köfte", "Turkish", 15));
        foodList.add(new Food("Pasta", "Italian", 35));

        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p3.jpeg");
        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p0.jpeg");
        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p1.jpeg");
        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p2.jpeg");
        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p4.jpeg");
    }

    // Function to navigate to pages by entering their path parameter
    public static void navigate(ActionEvent event, String path){
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(Load.class.getResource(path)));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to throw a simple error alert popup
    public static void errorAlert(String header){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    // Function to throw a simple informative alert popup
    public static void infoAlert(String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Function to check if input is numerical
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
