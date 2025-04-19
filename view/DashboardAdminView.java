package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import view.AddUserView;

public class DashboardAdminView extends JFrame {

    private JButton btnAddProduct, btnViewProduct, btnStockIn, btnStockOut, btnViewUser, btnAddUser, btnLogout, btnViewReport;

    public DashboardAdminView(String role) {
        setTitle("Admin Dashboard");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        btnAddProduct = new JButton("Add Product");
        btnViewProduct = new JButton("View Products");
        btnStockIn = new JButton("Stock In");
        btnStockOut = new JButton("Stock Out");
        btnViewUser = new JButton("View Users");
        btnAddUser = new JButton("Add User");
        btnViewReport = new JButton("View Reports");
        btnLogout = new JButton("Logout");

        // Tambahkan ke layout
        add(btnAddProduct);
        add(btnViewProduct);
        add(btnStockIn);
        add(btnStockOut);
        add(btnViewUser);
        add(btnAddUser);
        add(btnViewReport);
        add(btnLogout);

        // Action listeners
        btnAddProduct.addActionListener((ActionEvent e) -> {
            new AddProductView(role);
        });

        btnViewProduct.addActionListener((ActionEvent e) -> {
            new ViewProductView(role);
        });

        btnStockIn.addActionListener((ActionEvent e) -> {
            new StockInView(role);
        });

        btnStockOut.addActionListener((ActionEvent e) -> {
            new StockOutView(role);
        });

        btnViewUser.addActionListener((ActionEvent e) -> {
            new ViewUserView(role);
        });

        btnAddUser.addActionListener((ActionEvent e) -> {
            new AddUserView(role);
        });

        btnViewReport.addActionListener((ActionEvent e) -> {
            new ReportView(); // Jika kamu punya ReportView
        });

        btnLogout.addActionListener((ActionEvent e) -> {
            dispose();
            new LoginView();
        });

        setVisible(true);
    }
}
