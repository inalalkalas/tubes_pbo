package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddProductView extends JFrame {
    private JTextField txtName, txtCategoryId, txtSubCategoryId, txtPrice, txtStock;
    private JButton btnSave, btnBack;
    private String role;

    public AddProductView(String role) {
        this.role = role;

        setTitle("Add Product");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        txtName = new JTextField();
        txtCategoryId = new JTextField();
        txtSubCategoryId = new JTextField();
        txtPrice = new JTextField();
        txtStock = new JTextField();
        btnSave = new JButton("Save");
        btnBack = new JButton("Back");

        add(new JLabel("Product Name:"));
        add(txtName);
        add(new JLabel("Category ID:"));
        add(txtCategoryId);
        add(new JLabel("SubCategory ID:"));
        add(txtSubCategoryId);
        add(new JLabel("Price:"));
        add(txtPrice);
        add(new JLabel("Stock Quantity:"));
        add(txtStock);
        add(btnSave);
        add(btnBack);

        btnSave.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Product saved!");
            dispose();
            new DashboardStaffView(role);
        });

        btnBack.addActionListener((ActionEvent e) -> {
            dispose();
            new DashboardStaffView(role);
        });

        setVisible(true);
    }
}
