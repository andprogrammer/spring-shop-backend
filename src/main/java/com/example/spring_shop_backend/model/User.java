package com.example.spring_shop_backend.model;

public class User {
    private final double id;
    private final Cart cart;

    public User(double id) {
        this.id = id;
        cart = new Cart();
    }

    public double getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }
}
