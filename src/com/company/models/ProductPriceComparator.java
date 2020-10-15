package com.company.models;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare((int)p1.getPrice(),(int)p2.getPrice());
    }
}
