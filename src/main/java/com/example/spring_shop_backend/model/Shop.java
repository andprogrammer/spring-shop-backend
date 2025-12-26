package com.example.spring_shop_backend.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final List<Product> products = new ArrayList<>();

    // Add a product to the shop
    public void addProduct(Product product) {
        products.add(product);
    }

    // Get all products in the shop
    public List<Product> getProducts() {
        return products;
    }

    // Optional: You could add other shop-related functionality here like removing a product, etc.
    public Product findProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);  // Return null if not found
    }
}
