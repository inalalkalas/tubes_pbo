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
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DbConnection.getConnection();
            // Changed "products" to "product" to match your other methods
            String query = "SELECT * FROM product";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("price")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
