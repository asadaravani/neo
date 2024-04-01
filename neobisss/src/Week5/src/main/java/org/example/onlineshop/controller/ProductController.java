package org.example.onlineshop.controller;

import org.example.onlineshop.entity.Product;
import org.example.onlineshop.service.ProductService;
import org.example.onlineshop.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Get all products.
     *
     * @return List of products.
     */
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    /**
     * Get products by ID.
     * This endpoint returns an Optional containing the product, as it may or may not exist
     *
     * @return Optional<Product>
     */
    @GetMapping("{id}")
    public Optional<Product> findProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }


    /**
     * Add a new product by using a request body.
     * This method adds a product based on the provided request body
     * It should contain name and price of the product will be added.
     *
     * @body product    The body of the product.
     * @return          A product added.
     */
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO product){
        return ResponseEntity.ok(productService.addProduct(product));
    }


    /**
     * Update a product by specifying its body.
     *
     * This method updates the details of an existing product identified by the provided body.
     * It sets the new name and price for the product and saves the changes to the DB.
     * It gives respond if product doesn't exist in the DB
     *
     * @param productDTO  product.
     * @return            A product which is updated.
     */
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(productDTO));
    }


    /**
     * Deleting the product by specifying its ID
     *
     * This method deletes the product by ID
     * Saves the change to the DB
     * It gives respond if product doesn't exist in the DB
     *
     * @param id The ID of the product for deleting.
     * @return   A message indicating the success of the removing of the product.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.deleteProductById(id));
    }


    /**
     * Delete all existing products.
     *
     * This method deletes all the products in the BD
     *
     * @return A message informs a successful deletion of all products .
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllProducts(){
        return ResponseEntity.ok(productService.deleteAllProducts());
    }

}
