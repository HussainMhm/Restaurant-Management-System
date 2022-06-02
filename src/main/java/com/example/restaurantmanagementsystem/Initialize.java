package com.example.restaurantmanagementsystem;

import static com.example.restaurantmanagementsystem.Kitchen.foodList;

public class Initialize {
    public static void initializeData(){
        foodList.add(new Food("Shawarma", "Arabic", 20));
        foodList.add(new Food("Pizza", "Italian", 20));
        foodList.add(new Food("Burger", "American", 20));
        foodList.add(new Food("Kebap", "Turkish", 20));
    }
}
