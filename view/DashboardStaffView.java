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
        btnAddProduct.addActionListener(e -> new AddProductView(role));
        btnViewProduct.addActionListener(e -> new ViewProductView(role));
        btnStockIn.addActionListener(e -> new StockInView(role));
        btnStockOut.addActionListener(e -> new StockOutView(role));
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginView();
        });

        setVisible(true);
    }
}
