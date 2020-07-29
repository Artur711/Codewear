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

    public Product(String name, String gender, String type, String colour, String sizes, int prices, int quantity) {
        this(9999, name, gender, type, colour, sizes, prices, quantity);
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

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id -> " + id + "\n" +
                "name -> " + name + "\n" +
                "gender -> " + gender + "\n" +
                "type -> " + type + "\n" +
                "colour -> " + colour + "\n" +
                "sizes -> " + sizes + "\n" +
                "prices -> " + prices + "\n" +
                "quantity -> " + quantity;
    }
}
