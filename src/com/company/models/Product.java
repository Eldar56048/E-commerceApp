package com.company.models;

public class Product {
    private long id;
    private String name;
    private double price;
    private String structure;
    private String category;
    private String photoUrl;


    public Product(long id, String name, double price, String structure, String category, String photoUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.structure = structure;
        this.category = category;
        this.photoUrl = photoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
