package com.codecool.model;

public class Product {
    private final int id;
    private final String name;
    private final String gender;
    private final String type;
    private final String colour;
    private final String sizes;
    private final double price;
    private final int quantity;

    public Product(int id, String name, String gender, String type, String colour, String sizes, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.colour = colour;
        this.sizes = sizes;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public String getSizes() {
        return sizes;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
