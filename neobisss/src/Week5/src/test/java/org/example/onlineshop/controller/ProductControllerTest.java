package org.example.onlineshop.controller;

import org.example.onlineshop.dto.ProductDTO;
import org.example.onlineshop.entity.Product;
import org.example.onlineshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    private ProductController productController;
    @Mock
    private ProductService productService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productService);
    }
    @Test
    void addProducts(){
        ProductDTO productDTO = ProductDTO.builder()
                .productName("Winston")
                .price(BigDecimal.valueOf(145.60)).build();
        ResponseEntity<Product> ans = productController.addProduct(productDTO);
        assertEquals(HttpStatus.OK, ans.getStatusCode());
    }
    @Test
    void updateProduct(){
        ProductDTO productDTO = ProductDTO.builder()
                .id(1L)
                .productName("LD2")
                .price(BigDecimal.valueOf(158.99))
                .build();
        ResponseEntity<Product> ans = productController.updateProduct(productDTO);
        assertEquals(HttpStatus.OK, ans.getStatusCode());
    }
    @Test
    void deleteById(){
        ResponseEntity<String> ans = productController.deleteProductById(1L);
        assertEquals(HttpStatus.OK, ans.getStatusCode());
    }
    @Test
    void findProductById(){
        Product product = new Product();
        when(productService.findProductById(1L)).thenReturn(Optional.of(product));
        Optional<Product> ans = productController.findProductById(1L);
        assertTrue(ans.isPresent());
    }
}