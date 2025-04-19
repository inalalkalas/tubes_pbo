package dao;

import model.User;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Menambahkan user baru
    public boolean addUser(User user) {
        String sql = "INSERT INTO user (user_name, user_password, user_role) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mendapatkan semua user
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int userID = rs.getInt("user_id");
                String username = rs.getString("user_name");
                String password = rs.getString("user_password");
                String role = rs.getString("user_role");

                User user = new User(userID, username, password, role);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Menghapus user berdasarkan ID
    public boolean deleteUser(int userID) {
        String sql = "DELETE FROM user WHERE user_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userID);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mengubah informasi user
    public boolean updateUser(int userID, String username, String password, String role) {
        String sql = "UPDATE user SET user_name = ?, user_password = ?, user_role = ? WHERE user_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setInt(4, userID);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mendapatkan user berdasarkan username
    public User getUsername(String username) {
        String sql = "SELECT * FROM user WHERE user_name = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("user_id");
                String user = rs.getString("user_name");
                String pass = rs.getString("user_password");
                String role = rs.getString("user_role");
                return new User(id, user, pass, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
