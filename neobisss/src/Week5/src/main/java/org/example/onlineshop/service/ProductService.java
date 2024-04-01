package org.example.onlineshop.service;

import org.example.onlineshop.entity.Product;
import org.example.onlineshop.exception.EmptyFieldException;
import lombok.AllArgsConstructor;
import org.example.onlineshop.dto.ProductDTO;
import org.example.onlineshop.exception.ProductNotFoundException;
import org.example.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    public Optional<Product> findProductById(Long id){
        return this.productRepository.findById(id);
    }
    public  Product addProduct(String productName, BigDecimal price){
        ProductDTO productDto = new ProductDTO();
        productDto.setProductName(productName);
        productDto.setPrice(price);
        return addProduct(productDto);
    }
    public Product addProduct(ProductDTO productDTO){
        if(productDTO.getProductName().isEmpty() || productDTO.getProductName().equals(" ")){
            throw new EmptyFieldException("The field must not be empty!");
        }
        else if(productDTO.getPrice().equals(BigDecimal.valueOf(0))){
            throw new EmptyFieldException("The field must not be empty!");
        }
        else{
            Product product = new Product();
            product.setProductName(productDTO.getProductName());
            product.setPrice(productDTO.getPrice());
            this.productRepository.save(product);
            return product;
        }
    }
    public Product updateProduct(ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(productDTO.getId());
        if(product.isPresent()){
            Product updateProduct = product.get();
            updateProduct.setProductName(productDTO.getProductName());
            updateProduct.setPrice(productDTO.getPrice());
            this.productRepository.save(updateProduct);
            return updateProduct;
        }
        else{
            throw new ProductNotFoundException("Product not found!");
        }
    }
    public String deleteProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            this.productRepository.deleteById(id);
            return "Product deleted with id: " + id;
        }
        else{
            throw new ProductNotFoundException("Product not found!");
        }
    }
    public String deleteAllProducts()throws ProductNotFoundException{
        if(this.productRepository.findAll().isEmpty()){
            throw  new ProductNotFoundException("DB is already clear!");
        }
        else {
            this.productRepository.deleteAll();
            return "All are deleted!!!";
        }
    }
}
