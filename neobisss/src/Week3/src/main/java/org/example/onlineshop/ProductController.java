package org.example.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    @PostMapping
    public void addProduct(@RequestParam String productName, @RequestParam double price){
        System.out.println("Success!!! " + productName + " " + price);
    }
    @PostMapping("/addProduct2")
    public void addProduct2(@RequestBody Product product){
        System.out.println("Success!!! " + product.toString());
        this.productRepository.
    }





}
