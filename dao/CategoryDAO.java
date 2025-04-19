package dao;

import model.Category;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    // Menambahkan kategori baru (baik untuk Category, SubCategory, atau SubSubCategory)
    public void addCategory(Category category) {
        String sql = "INSERT INTO category (category_name, description) VALUES (?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan daftar semua kategori
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int categoryID = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String description = rs.getString("description");

                Category category = new Category(categoryID, categoryName, description) {
                    @Override
                    public void displayCategoryDetails() {
                        System.out.println("Category: " + getCategoryName());
                        System.out.println("Description: " + getDescription());
                    }
                };

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // Menghapus kategori berdasarkan ID
    public void deleteCategory(int categoryID) {
        String sql = "DELETE FROM category WHERE category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengubah nama dan deskripsi kategori
    public void updateCategory(int categoryID, String categoryName, String description) {
        String sql = "UPDATE category SET category_name = ?, description = ? WHERE category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoryName);
            ps.setString(2, description);
            ps.setInt(3, categoryID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
