package dao;

import model.Product;
import utils.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Menambahkan produk baru
    public void addProduct(Product product) {
        String sql = "INSERT INTO product (product_name, category_id, sub_category_id, sub_sub_category_id, price, product_stock) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryID());
            ps.setInt(3, product.getSubCategoryID());
            ps.setInt(4, product.getSubSubCategoryID());
            ps.setDouble(5, product.getProductPrice());
            ps.setInt(6, product.getStock());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT productID, product_name, product_price FROM `mydb`.`product`";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("productID");
                String name = rs.getString("product_name");
                double price = rs.getDouble("product_price");
                
                Product product = new Product(id, name, price);
                products.add(product);
                
                // Debug output
                System.out.println("Added product: ID=" + id + ", Name=" + name + ", Price=" + price);
            }
            
            System.out.println("Retrieved " + products.size() + " products total");
            
        } catch (SQLException e) {
            System.err.println("Error fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        
        return products;
    }
    
    // Mengubah informasi produk
    public void updateProduct(int productID, String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int product_stock) {
        String sql = "UPDATE product SET product_name = ?, category_id = ?, sub_category_id = ?, sub_sub_category_id = ?, price = ?, product_stock = ? WHERE product_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, productName);
            ps.setInt(2, categoryID);
            ps.setInt(3, subCategoryID);
            ps.setInt(4, subSubCategoryID);
            ps.setDouble(5, price);
            ps.setInt(6, product_stock);
            ps.setInt(7, productID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
