package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class Main {
    private static String dbName = "jdbc:mysql://localhost:3306/NeoShop";
    private static String username = "root";
    private static String password = "password";
    public static void main(String[] args) throws SQLException {
        Product.setProductId(621262);
        Product.setProductName("LD Blue");
        Product.setPrice(159.99);
        Product.setQuantityAvailable(5);
        //addProduct();
        //updateProduct();
        deleteProduct();
    }
    public static void addProduct() {
        String query = "INSERT INTO `NeoShop`.`Product`(productId, productName, price, quantityAvailable) " +
                "VALUES (?, ?, ?, ?)";
        try(Connection connection = DriverManager.getConnection(dbName, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, Product.getProductId());
            preparedStatement.setString(2, Product.getProductName());
            preparedStatement.setDouble(3, Product.getPrice());
            preparedStatement.setInt(4, Product.getQuantityAvailable());
            preparedStatement.executeUpdate();
            System.out.println("A product connecteeda succesfulee!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void updateProduct() {
        String query = "UPDATE `NeoShop`.`Product` " +
                "SET productName = ?, price = ?, quantityAvailable = ? WHERE productId = ?";
        try(Connection connection = DriverManager.getConnection(dbName, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, Product.getProductName());
            preparedStatement.setDouble(2, Product.getPrice());
            preparedStatement.setInt(3, Product.getQuantityAvailable());
            preparedStatement.setInt(4, Product.getProductId());
            preparedStatement.executeUpdate();
            System.out.println("Updated!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteProduct() {
        String query = "DELETE FROM `NeoShop`.`Product` WHERE productId = ?";
        try(Connection connection = DriverManager.getConnection(dbName, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, Product.getProductId());
            preparedStatement.executeUpdate();
            System.out.println("Deleted!");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
