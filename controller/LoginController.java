package controller;

import view.LoginView;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        // Add action listener to the login button
        loginView.getLoginButton().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        // Basic validation
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Database authentication
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("user_role");
                    JOptionPane.showMessageDialog(loginView, "Login successful as " + role, "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Proceed to the next view based on role (admin or staff)
                } else {
                    JOptionPane.showMessageDialog(loginView, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Database connection error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
