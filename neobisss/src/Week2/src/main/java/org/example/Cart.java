package org.example;

import java.util.List;

public class Cart {
    private int cartId;
    private Customer customer;
    private List<Product> cartItems;
    private double totalAmount;

    public Cart(int cartId, Customer customer, List<Product> cartItems, double totalAmount) {
        this.cartId = cartId;
        this.customer = customer;
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
