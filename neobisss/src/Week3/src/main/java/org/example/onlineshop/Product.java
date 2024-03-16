package org.example.onlineshop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private double price;

    public Product(long id, String productName, double price) {
        super();
        this.productName = productName;
    }

    public Product() {}

    public long getId() {
        return id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
