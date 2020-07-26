package com.codecool.model;

public class Product {
    private Object id;
    private Object name;
    private Object gender;
    private Object type;
    private Object colour;
    private Object sizes;
    private Object prices;
    private Object quantity;

    public Product(Object id, Object name, Object gender, Object type, Object colour, Object sizes, Object prices, Object quantity) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.colour = colour;
        this.sizes = sizes;
        this.prices = prices;
        this.quantity = quantity;
    }

    public Object getId() {
        return id;
    }

    public Object getName() {
        return name;
    }

    public Object getGender() {
        return gender;
    }

    public Object getType() {
        return type;
    }

    public Object getColour() {
        return colour;
    }

    public Object getSizes() {
        return sizes;
    }

    public Object getPrices() {
        return prices;
    }

    public Object getQuantity() {
        return quantity;
    }
}
