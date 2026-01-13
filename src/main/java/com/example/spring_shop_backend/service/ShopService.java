package com.example.spring_shop_backend.service;

import com.example.spring_shop_backend.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final Shop shop = new Shop();

    public Product addProductToShop(String name, double price) {
        Product product = new Product(name, price);
        shop.addProduct(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return shop.getProducts();
    }

    public Product findProductByName(String name) {
        return shop.findProductByName(name);
    }
}
