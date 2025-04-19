package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StockInView extends JFrame {
    private JTextField txtProductId, txtQuantity;
    private JButton btnSubmit, btnBack;
    private String role;

    public StockInView(String role) {
        this.role = role;

        setTitle("Stock In");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        txtProductId = new JTextField();
        txtQuantity = new JTextField();
        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");

        add(new JLabel("Product ID:"));
        add(txtProductId);
        add(new JLabel("Quantity In:"));
        add(txtQuantity);
        add(btnSubmit);
        add(btnBack);

        btnSubmit.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Stock in recorded!");
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
