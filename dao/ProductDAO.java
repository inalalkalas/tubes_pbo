package dao;

import model.Product;
import utils.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Menambahkan produk baru
    public void addProduct(Product product) {
        String sql = "INSERT INTO product (product_name, category_id, sub_category_id, sub_sub_category_id, price, stock_quantity) VALUES (?, ?, ?, ?, ?, ?)";

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

    // Mendapatkan daftar produk
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int productID = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int categoryID = rs.getInt("category_id");
                int subCategoryID = rs.getInt("sub_category_id");
                int subSubCategoryID = rs.getInt("sub_sub_category_id");
                double price = rs.getDouble("price");
                int product_stock = rs.getInt("product_stock");

                Product product = new Product(productID, productName, categoryID, subCategoryID, subSubCategoryID, price, product_stock);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Menghapus produk berdasarkan ID
    public void deleteProduct(int productID) {
        String sql = "DELETE FROM product WHERE product_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
