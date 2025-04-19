package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import utils.DbConnection;
import utils.DbConnection;
import view.DashboardAdminView;
import view.DashboardStaffView;

public class StaffView extends JFrame {

    private JList<String> productList;
    private DefaultListModel<String> listModel;

    public StaffView(String role) {
        setTitle("Staff Menu");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Welcome, " + role);
        add(label);

        // Setup List to display products
        listModel = new DefaultListModel<>();
        productList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane);

        // Button to go back to the dashboard
        JButton btnBack = new JButton("Back to Dashboard");
        add(btnBack);

        btnBack.addActionListener((ActionEvent e) -> {
            dispose();
            if (role.equals("admin")) {
                new DashboardAdminView(role);
            } else {
                new DashboardStaffView(role);
            }
        });

        // Load products from the database
        loadProductsFromDatabase();

        setVisible(true);
    }

    // Method to load products from the database
    private void loadProductsFromDatabase() {
        String query = "SELECT name FROM products"; // Sesuaikan dengan nama tabel dan kolom yang ada di database

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Clear the list before adding new data
            listModel.clear();

            // Add products to the list
            while (rs.next()) {
                String productName = rs.getString("name"); // Sesuaikan dengan nama kolom yang ada di tabel
                listModel.addElement(productName);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
        }
    }
}
