package com.example.restaurantmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;


public class MenuCtrl implements Initializable {
    @FXML
    private Button backBtn;
    @FXML
    private Button sortBtn;
    @FXML
    private ChoiceBox<String> sortChoice;
    @FXML
    private TableView<Food> menuTable;
    @FXML
    private TableColumn<Food, String> foodNameColumn;
    @FXML
    private TableColumn<Food, String> foodCategoryColumn;
    @FXML
    private TableColumn<Food, Float> foodPriceColumn;

    ObservableList<Food> foodObservableList = FXCollections.observableArrayList();

    QuickSort quickSort = new QuickSort();

    boolean dec;

    // Implementing quicksort for food menu and displaying them in table
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sortChoice.getItems().addAll("Name", "Category", "Price");

        foodNameColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        foodCategoryColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("category"));
        foodPriceColumn.setCellValueFactory(new PropertyValueFactory<Food, Float>("price"));

        foodObservableList.addAll(foodList);
        menuTable.setItems(foodObservableList);

        foodNameColumn.setSortable(false);
        foodCategoryColumn.setSortable(false);
        foodPriceColumn.setSortable(false);

        sortBtn.setOnAction(event -> {
            for ( int i = 0; i < menuTable.getItems().size(); i++)
                menuTable.getItems().clear();

            switch (sortChoice.getValue()) {
                case "Name" -> {
                    String[] arr = new String[foodList.size()];
                    for (Food food : foodList)
                        arr[foodList.indexOf(food)] = food.getName();
                    quickSort.sort(arr, dec);

                    int[] indexes = new int[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        for (Food food : foodList) {
                            if(arr[i].equals(food.getName()))
                                indexes[i] = foodList.indexOf(food);
                        }
                    }
                    setSortedTableValue(indexes);
                }
                case "Category" -> {
                    String[] arr = new String[foodList.size()];
                    for (Food food : foodList)
                        arr[foodList.indexOf(food)] = food.getCategory();
                    quickSort.sort(arr, dec);

                    int[] indexes = new int[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        for (Food food : foodList) {
                            if (Objects.equals(arr[i], food.getCategory()))
                                indexes[i] = foodList.indexOf(food);
                        }
                    }
                    setSortedTableValue(indexes);
                }
                case "Price" -> {
                    int[] arr = new int[foodList.size()];
                    for (Food food : foodList)
                        arr[foodList.indexOf(food)] = (int) food.getPrice();
                    quickSort.sort(arr, 0, foodList.size() - 1, dec);

                    int[] indexes = new int[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        for (Food food : foodList) {
                            if (arr[i] == food.getPrice())
                                indexes[i] = foodList.indexOf(food);
                        }
                    }
                    setSortedTableValue(indexes);
                }
            }
        });
    }

    // code block used many times / to prevent repetition
    public void setSortedTableValue(int[] indexes){
        for (int i : indexes)
            foodObservableList.add(foodList.get(i));

        menuTable.setItems(foodObservableList);
        dec = !dec;
    }

    public void navigateBack(ActionEvent event){
        Load.navigate(event, "CustomerScreen.fxml");
    }
}
