package com.codecool.model;

public class Product {
    private int id;
    private String name;
    private String gender;
    private String type;
    private String colour;
    private String sizes;
    private int prices;
    private int quantity;

    public Product(int id, String name, String gender, String type, String colour, String sizes, int prices, int quantity) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.colour = colour;
        this.sizes = sizes;
        this.prices = prices;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public int getPrices() {
        return prices;
    }

    public int getQuantity() {
        return quantity;
    }
}
