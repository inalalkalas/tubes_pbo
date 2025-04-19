package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DashboardStaffView extends JFrame {

    private JButton btnAddProduct, btnViewProduct, btnStockIn, btnStockOut, btnLogout;

    public DashboardStaffView(String role) {
        setTitle("Staff Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Initialize buttons
        btnAddProduct = new JButton("Add Product");
        btnViewProduct = new JButton("View Products");
        btnStockIn = new JButton("Stock In");
        btnStockOut = new JButton("Stock Out");
        btnLogout = new JButton("Logout");

        // Add buttons to frame
        add(btnAddProduct);
        add(btnViewProduct);
        add(btnStockIn);
        add(btnStockOut);
        add(btnLogout);

        // Button Actions
        btnAddProduct.addActionListener(e -> {
            new AddProductView(role).setVisible(true); // Make the new view visible
        });

        btnViewProduct.addActionListener(e -> {
            new ViewProductView(role).setVisible(true); // Make the new view visible
        });

        btnStockIn.addActionListener(e -> {
            new StockInView(role).setVisible(true); // Make the new view visible
        });

        btnStockOut.addActionListener(e -> {
            new StockOutView(role).setVisible(true); // Make the new view visible
        });

        btnLogout.addActionListener(e -> {
            dispose(); // Close the current Dashboard
            new LoginView().setVisible(true); // Show LoginView again
        });

        setVisible(true);
    }
}
