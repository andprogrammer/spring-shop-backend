package com.example.spring_shop_backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @Test
    void testAddProduct() {
        Product product = new Product("Laptop", 899.99);
        shop.addProduct(product);

        // Assert that the product is added to the shop
        assertEquals(1, shop.getProducts().size());
        assertEquals("Laptop", shop.getProducts().get(0).getName());
        assertEquals(899.99, shop.getProducts().get(0).getPrice());
    }

    @Test
    void testFindProductByName() {
        Product product = new Product("Smartphone", 499.99);
        shop.addProduct(product);

        // Test that the product is found by name
        Product foundProduct = shop.findProductByName("Smartphone");
        assertNotNull(foundProduct);
        assertEquals("Smartphone", foundProduct.getName());
        assertEquals(499.99, foundProduct.getPrice());
    }

    @Test
    void testFindProductByNameNotFound() {
        // Test that null is returned if the product is not found
        Product foundProduct = shop.findProductByName("NonExistentProduct");
        assertNull(foundProduct);
    }
}

