package com.example.spring_shop_backend.service;

import com.example.spring_shop_backend.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    private ShopService shopService;

    @BeforeEach
    void setUp() {
        shopService = new ShopService();  // Using the real service (no mock needed here)
    }

    @Test
    void testAddProductToShop() {
        Product product = shopService.addProductToShop("Laptop", 899.99);

        // Test that the product was added
        assertNotNull(product);
        assertEquals("Laptop", product.getName());
        assertEquals(899.99, product.getPrice());
    }

    @Test
    void testGetAllProducts() {
        shopService.addProductToShop("Laptop", 899.99);
        shopService.addProductToShop("Smartphone", 499.99);

        // Test that all products are returned
        assertEquals(2, shopService.getAllProducts().size());
    }

    @Test
    void testFindProductByName() {
        shopService.addProductToShop("Smartphone", 499.99);

        // Test that the product can be found by its name
        Product product = shopService.findProductByName("Smartphone");
        assertNotNull(product);
        assertEquals("Smartphone", product.getName());
        assertEquals(499.99, product.getPrice());
    }
}
