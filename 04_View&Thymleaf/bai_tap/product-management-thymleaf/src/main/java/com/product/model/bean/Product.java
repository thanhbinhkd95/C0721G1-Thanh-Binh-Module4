package com.product.model.bean;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private String description;
    private String manufacture;

    public Product() {
    }

    public Product(String nameProduct, double price, String description, String manufacture) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
    }

    public Product(int id, String nameProduct, double price, String description, String manufacture) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
