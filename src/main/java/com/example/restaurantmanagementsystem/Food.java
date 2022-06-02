package com.example.restaurantmanagementsystem;

public class Food {
    private String name;
    private String category;
    private float price;

    // variable for image

    public Food(String name, String category, float price) {
        this.name = name;
        this.category = category;
        this.price = price;
        // this.image also
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }
}
