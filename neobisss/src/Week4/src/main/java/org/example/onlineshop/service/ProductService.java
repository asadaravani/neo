package org.example.onlineshop.service;

import lombok.AllArgsConstructor;
import org.example.onlineshop.dto.ProductDTO;
import org.example.onlineshop.entity.Product;
import org.example.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    public Optional<Product> findProductById(long id){
        return this.productRepository.findById(id);
    }
    public  ResponseEntity<String> addProduct(String productName, double price){
        ProductDTO productDto = new ProductDTO();
        Product product = new Product();
        productDto.setProductName(productName);
        productDto.setPrice(price);
        if(productDto.getProductName().isEmpty() || productDto.getProductName().equals(" ")){
            return ResponseEntity.badRequest().body("Product name is required!") ;
        }
        else if(productDto.getPrice() == 0.0){
            return ResponseEntity.badRequest().body("Product price is required!") ;
        }
        else{
            product.setId(productDto.getId());
            product.setProductName(productDto.getProductName());
            product.setPrice(productDto.getPrice());
            this.productRepository.save(product);
            System.out.println("Added:  " + product.toString());
            return ResponseEntity.ok("Added:  " + product.toString());
        }
    }
    public ResponseEntity<String> addProductBody(ProductDTO productDto){
        Product product = new Product();
        if(productDto.getProductName().isEmpty() || productDto.getProductName().equals(" ")){
            return ResponseEntity.badRequest().body("Product name is required!") ;
        }
        else if(productDto.getPrice() == 0.0){
            return ResponseEntity.badRequest().body("Product price is required!") ;
        }
        else{
            product.setId(productDto.getId());
            product.setProductName(productDto.getProductName());
            product.setPrice(productDto.getPrice());
            this.productRepository.save(product);
            System.out.println("Added:  " + product.toString());
            return ResponseEntity.ok("Added:  " + product.toString());
        }
    }
    public ResponseEntity<String> editProductById(long id, String productName, double price) {
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
    public ResponseEntity<String> deleteProductById(long id){
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
    public String deleteAllProducts(){
        this.productRepository.deleteAll();
        System.out.println("All are deleted!");
        return "All are deleted!";
    }
}
