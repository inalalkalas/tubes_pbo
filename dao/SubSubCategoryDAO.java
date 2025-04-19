package dao;

import model.SubSubCategory;
import utils.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubSubCategoryDAO {

    // Menambahkan sub-subkategori baru
    public void addSubSubCategory(SubSubCategory subSubCategory) {
        String sql = "INSERT INTO sub_sub_category (category_name, description, parent_category_id, parent_sub_category_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, subSubCategory.getCategoryName());
            ps.setString(2, subSubCategory.getDescription());
            ps.setInt(3, subSubCategory.getParentCategoryID());
            ps.setInt(4, subSubCategory.getParentSubCategoryID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan semua sub-subkategori berdasarkan ID subkategori induk
    public List<SubSubCategory> getSubSubCategoriesByParentID(int parentSubCategoryID) {
        List<SubSubCategory> subSubCategories = new ArrayList<>();
        String sql = "SELECT * FROM sub_sub_category WHERE parent_sub_category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, parentSubCategoryID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int categoryID = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String description = rs.getString("description");
                int parentCategoryID = rs.getInt("parent_category_id");
                int parentSubCategoryIDFromDB = rs.getInt("parent_sub_category_id");

                SubSubCategory subSubCategory = new SubSubCategory(categoryID, categoryName, description, parentCategoryID, parentSubCategoryIDFromDB);
                subSubCategories.add(subSubCategory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subSubCategories;
    }

    // Menghapus sub-subkategori berdasarkan ID
    public void deleteSubSubCategory(int categoryID) {
        String sql = "DELETE FROM sub_sub_category WHERE category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengubah informasi sub-subkategori
    public void updateSubSubCategory(int categoryID, String categoryName, String description, int parentCategoryID, int parentSubCategoryID) {
        String sql = "UPDATE sub_sub_category SET category_name = ?, description = ?, parent_category_id = ?, parent_sub_category_id = ? WHERE category_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoryName);
            ps.setString(2, description);
            ps.setInt(3, parentCategoryID);
            ps.setInt(4, parentSubCategoryID);
            ps.setInt(5, categoryID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
