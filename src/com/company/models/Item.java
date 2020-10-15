package com.company.models;

public class Item {
    private Product product;
    private int quantity;
    private double total;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.total = quantity * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.quantity * this.product.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
