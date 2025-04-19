package controller;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.util.List;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    // Menambahkan user baru
    public void addUser(String username, String password, String role) {
        User user = new User(username, password, role);
        if (userDAO.addUser(user)) {
            JOptionPane.showMessageDialog(null, "User added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error adding user!");
        }
    }

    // Mengupdate informasi user
    public void updateUser(int userID, String userName, String password, String role) {
        if (userDAO.updateUser(userID, userName, password, role)) {
            JOptionPane.showMessageDialog(null, "User updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error updating user!");
        }
    }

    // Menghapus user
    public void deleteUser(int userID) {
        if (userDAO.deleteUser(userID)) {
            JOptionPane.showMessageDialog(null, "User deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting user!");
        }
    }

    // Login check
    public User login(String username, String password) {
        User user = userDAO.getUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password!");
            return null;
        }
    }

    // Mendapatkan semua pengguna
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
