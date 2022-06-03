package com.example.restaurantmanagementsystem;

public class Order {
    public String customer;

    public Order(String customerName) {
        this.customer = customerName;
    }

    public String getCustomer() {
        return customer;
    }
}
