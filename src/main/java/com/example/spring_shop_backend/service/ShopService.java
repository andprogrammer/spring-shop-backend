package com.example.spring_shop_backend.service;

import com.example.spring_shop_backend.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final Shop shop = new Shop();  // In-memory Shop instance

    // Add a product to the shop
    public Product addProductToShop(String name, double price) {
        Product product = new Product(name, price);
        shop.addProduct(product);
        return product;  // Return the created product
    }

    // Get all products in the shop
    public List<Product> getAllProducts() {
        return shop.getProducts();
    }

    // Optional: Find a product by name
    public Product findProductByName(String name) {
        return shop.findProductByName(name);
    }
}
