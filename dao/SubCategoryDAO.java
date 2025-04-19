package dao;

import model.SubCategory;
import utils.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDAO {

    // Menambahkan subkategori baru
    public void addSubCategory(SubCategory subCategory) {
        String sql = "INSERT INTO sub_category (category_name, description, parent_category_id) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, subCategory.getCategoryName());
            ps.setString(2, subCategory.getDescription());
            ps.setInt(3, subCategory.getParentCategoryID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan semua subkategori berdasarkan ID kategori induk
    public List<SubCategory> getSubCategoriesByParentID(int parentCategoryID) {
        List<SubCategory> subCategories = new ArrayList<>();
        String sql = "SELECT * FROM sub_category WHERE parent_category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, parentCategoryID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int categoryID = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String description = rs.getString("description");
                int parentCategoryIDFromDB = rs.getInt("parent_category_id");

                SubCategory subCategory = new SubCategory(categoryID, categoryName, description, parentCategoryIDFromDB);
                subCategories.add(subCategory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subCategories;
    }

    // Menghapus subkategori berdasarkan ID
    public void deleteSubCategory(int categoryID) {
        String sql = "DELETE FROM sub_category WHERE category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengubah informasi subkategori
    public void updateSubCategory(int categoryID, String categoryName, String description, int parentCategoryID) {
        String sql = "UPDATE sub_category SET category_name = ?, description = ?, parent_category_id = ? WHERE category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoryName);
            ps.setString(2, description);
            ps.setInt(3, parentCategoryID);
            ps.setInt(4, categoryID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
