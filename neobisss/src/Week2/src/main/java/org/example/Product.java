package org.example;

public class Product {
    private static int productId;
    private static String productName;
    private static String description;
    private static double price;
    private static int quantityAvailable;

    public Product(int productId, String productName, String description, double price, int quantityAvailable) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public static int getProductId() {
        return productId;
    }

    public static void setProductId(int productId) {
        Product.productId = productId;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        Product.productName = productName;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Product.description = description;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        Product.price = price;
    }

    public static int getQuantityAvailable() {
        return quantityAvailable;
    }

    public static void setQuantityAvailable(int quantityAvailable) {
        Product.quantityAvailable = quantityAvailable;
    }
}
