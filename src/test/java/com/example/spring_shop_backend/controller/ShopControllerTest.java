package com.example.spring_shop_backend.controller;

import com.example.spring_shop_backend.model.Product;
import com.example.spring_shop_backend.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class ShopControllerTest {

    @Mock
    private ShopService shopService;

    @InjectMocks
    private ShopController shopController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(shopController).build();
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product("Laptop", 899.99);
        when(shopService.addProductToShop("Laptop", 899.99)).thenReturn(product);

        mockMvc.perform(post("/shop/products")
                        .param("name", "Laptop")
                        .param("price", "899.99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(899.99));
    }

    @Test
    void testGetAllProducts() throws Exception {
        Product product1 = new Product("Laptop", 899.99);
        Product product2 = new Product("Smartphone", 499.99);

        when(shopService.getAllProducts()).thenReturn(List.of(product1, product2));

        mockMvc.perform(get("/shop/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[1].name").value("Smartphone"));
    }

    @Test
    void testGetProductByName() throws Exception {
        Product product = new Product("Smartphone", 499.99);
        when(shopService.findProductByName("Smartphone")).thenReturn(product);

        mockMvc.perform(get("/shop/products/Smartphone"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Smartphone"))
                .andExpect(jsonPath("$.price").value(499.99));
    }

    @Test
    void testGetProductByNameNotFound() throws Exception {
        when(shopService.findProductByName("NonExistentProduct")).thenReturn(null);

        mockMvc.perform(get("/shop/products/NonExistentProduct"))
                .andExpect(status().isNotFound());
    }
}
