/**
 * @file Restaurant Management System
 * @description Simple GUI application where more than 5 data structure type are used.
 * @assignment Data Structure Project
 * @date 04/06/2022
 * @author Hussain Abdullatif - Mohammad Salah
 */

package com.example.restaurantmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Restaurant Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Load.initializeData();
        launch();
    }
}