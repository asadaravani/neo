package org.example.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    @Autowired
    ProductRepository productRepository;

    /**
     * Get all products.
     *
     * @return List of products.
     */
    @GetMapping
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }


    /**
     * Get products by ID.
     *
     * @return Product.
     */
    @GetMapping("{id}")
    public Optional<Product> findProductById(@PathVariable long id){
        return this.productRepository.findById(id);
    }


    /**
     * Add a new product by parameters.
     *
     * @param productName The name of the product.
     * @param price       The price of the product.
     */
    @PostMapping
    public String addProduct(@RequestParam String productName, @RequestParam double price){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        this.productRepository.save(product);
        System.out.println("Added: " + product.toString());
        return "Added: " + product.toString();
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
    public ResponseEntity<String> addProduct2(@RequestBody Product product){
        if(product.getProductName().isEmpty() || product.getProductName().equals(" ")){
            return ResponseEntity.badRequest().body("Product name is required!") ;
        }
        else if(product.getPrice() == 0.0){
            return ResponseEntity.badRequest().body("Product price is required!") ;
        }
        else{
            this.productRepository.save(product);
            System.out.println("Added:  " + product.toString());
            return ResponseEntity.ok("Added:  " + product.toString());
        }
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
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product updateProduct = product.get();
            updateProduct.setProductName(productName);
            updateProduct.setPrice(price);
            this.productRepository.save(updateProduct);
            System.out.println("Updated! : "+updateProduct.toString());
            return ResponseEntity.ok("Updated! : "+updateProduct.toString());
        }
        else{
            System.out.println("Product not found for ID = " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found for ID = " + id);
        }
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
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            this.productRepository.deleteById(id);
            System.out.println("Product is deleted with ID = "+id);
            return ResponseEntity.ok("Product is deleted with ID = "+id);
        }
        else{
            System.out.println("Product not found for ID = " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found for ID = " + id);
        }
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
        this.productRepository.deleteAll();
        System.out.println("All are deleted!");
        return "All are deleted!";
    }

}
