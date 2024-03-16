package org.example.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    @Autowired
    ProductRepository productRepository;

    //
    @GetMapping
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    @GetMapping("{id}")
    public Optional<Product> findProductById(@PathVariable long id){
        return this.productRepository.findById(id);
    }
    @PostMapping
    public String addProduct(@RequestParam String productName, @RequestParam double price){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        this.productRepository.save(product);
        System.out.println("Added: " + product.toString());
        return "Added: " + product.toString();
    }
    @PostMapping("/addProductBody")
    public String addProduct2(@RequestBody Product product){
        this.productRepository.save(product);
        System.out.println("Added:  " + product.toString());
        return "Added:  " + product.toString();
    }
    @PutMapping("{id}")
    public String editProductById(@PathVariable long id,
                                @RequestParam String productName,
                                @RequestParam double price){
        Optional<Product> product = productRepository.findById(id);
        Product updateProduct = product.get();
        updateProduct.setProductName(productName);
        updateProduct.setPrice(price);
        this.productRepository.save(updateProduct);
        System.out.println("Updated! : "+updateProduct.toString());
        return "Updated! : "+updateProduct.toString();
    }
    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable long id){
        this.productRepository.deleteById(id);
        System.out.println("Deleted!");
        return "Deleted!";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAllProducts(){
        this.productRepository.deleteAll();
        System.out.println("All are deleted!");
        return "All are deleted!";
    }

}
