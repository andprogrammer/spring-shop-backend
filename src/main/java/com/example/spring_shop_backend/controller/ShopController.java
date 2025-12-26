package com.example.spring_shop_backend.controller;

import com.example.spring_shop_backend.model.Product;
import com.example.spring_shop_backend.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    // POST request to add a new product to the shop
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestParam String name, @RequestParam double price) {
        Product product = shopService.addProductToShop(name, price);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // GET request to view all products in the shop
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = shopService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // GET request to find a product by name
    @GetMapping("/products/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = shopService.findProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
