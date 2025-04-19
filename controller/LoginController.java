package controller;

import view.LoginView;
import view.DashboardAdminView;
import view.DashboardAdminView;
import view.DashboardStaffView;
import view.DashboardStaffView;
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

        // Tambahkan action listener untuk tombol login
        loginView.getLoginButton().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        // Validasi input
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Harap isi username dan password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Autentikasi ke database
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("user_role");

                    JOptionPane.showMessageDialog(loginView, "Login berhasil sebagai " + role, "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Buka dashboard berdasarkan role
                    if (role.equalsIgnoreCase("admin")) {
                        new DashboardAdminView(role).setVisible(true);
                    } else if (role.equalsIgnoreCase("staff")) {
                        new DashboardStaffView(role).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(loginView, "Role tidak dikenali!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Tutup jendela login
                    loginView.dispose();
                } else {
                    JOptionPane.showMessageDialog(loginView, "Username atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Gagal koneksi ke database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
