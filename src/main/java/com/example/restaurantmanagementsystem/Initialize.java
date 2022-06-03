package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;
import static com.example.restaurantmanagementsystem.GalleryCtrl.pathList;

public class Initialize {
    public static void initializeData(){
        foodList.add(new Food("Shawarma", "Arabic", 20));
        foodList.add(new Food("Pizza", "Italian", 20));
        foodList.add(new Food("Burger", "American", 20));
        foodList.add(new Food("Kebap", "Turkish", 20));

        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p0.jpeg");
        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p1.jpeg");
        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p2.jpeg");
//        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p3.jpeg");
//        pathList.add("file:src/main/java/com/example/restaurantmanagementsystem/Images/p4.jpeg");

    }

    public static void navigate(ActionEvent event, String path){
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(Initialize.class.getResource(path)));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

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
