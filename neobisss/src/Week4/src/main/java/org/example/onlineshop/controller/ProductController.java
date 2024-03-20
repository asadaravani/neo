package org.example.onlineshop.controller;

import org.example.onlineshop.dto.ProductDTO;
import org.example.onlineshop.entity.Product;
import org.example.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    @Autowired
    ProductService productService;

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
     *
     * @return Product.
     */
    @GetMapping("{id}")
    public Optional<Product> findProductById(@PathVariable long id){
        return productService.findProductById(id);
    }


    /**
     * Add a new product by parameters.
     *
     * @param productName The name of the product.
     * @param price       The price of the product.
     */
    @PostMapping
    public String addProduct(@RequestParam String productName, @RequestParam double price){
       return productService.addProduct(productName, price);
    }


    /**
     * Add a new product by using a request body.
     *
     * This method adds a product based on the provided request body
     * It should contain name and price of the product will be added.
     *
     * @body product    The body of the product.
     * @return          A message indicating the success of the add operation.
     */
    @PostMapping("/addProductBody")
    public ResponseEntity<String> addProduct2(@RequestBody ProductDTO product){
        return productService.addProductBody(product);
    }


    /**
     * Update a product by specifying its ID, name and price.
     *
     * This method updates the details of an existing product identified by the provided ID.
     * It sets the new name and price for the product and saves the changes to the DB.
     * It gives respond if product doesn't exist in the DB
     *
     * @param id          The ID of the product to update.
     * @param productName The new name of the product.
     * @param price       The new price of the product.
     * @return            A message indicating the success of the update operation.
     */
    @PutMapping("{id}")
    public ResponseEntity<String> editProductById(@PathVariable long id,
                                @RequestParam String productName,
                                @RequestParam double price) {
        return productService.editProductById(id, productName, price);
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
    public ResponseEntity<String> deleteProductById(@PathVariable long id){
        return productService.deleteProductById(id);
    }


    /**
     * Delete all existing products.
     *
     * This method deletes all the products in the BD
     *
     * @return A message informs a successful deletion of all products .
     */
    @DeleteMapping("/deleteAll")
    public String deleteAllProducts(){
        return productService.deleteAllProducts();
    }

}
