package view;

import controller.ProductController;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewProductView extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private ProductController productController;

    public ViewProductView(String role) {
        setTitle("View Products - Role: " + role);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        productController = new ProductController();

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"Product ID", "Product Name", "Price"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Add a back button
        JButton btnBack = new JButton("Back to Dashboard");
        add(btnBack, BorderLayout.SOUTH);

        btnBack.addActionListener(e -> {
            dispose();
            // Navigating back to the appropriate dashboard based on the role
            if (role.equals("admin")) {
                new DashboardAdminView(role);
            } else {
                new DashboardStaffView(role);
            }
        });

        loadProducts(); // Load the products into the table

        setVisible(true);
    }

    // Method to load products into the table
    private void loadProducts() {
        tableModel.setRowCount(0); // Clear existing rows
        try {
            List<Product> products = productController.getAllProducts();
            for (Product product : products) {
                tableModel.addRow(new Object[]{
                        product.getProductID(),
                        product.getProductName(),
                        product.getProductPrice()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
