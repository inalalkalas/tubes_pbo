package view;

import javax.swing.*;
import java.awt.*;
import view.DashboardAdminView;
import view.DashboardStaffView;

public class ViewProductView extends JFrame {

    public ViewProductView(String role) {
        setTitle("View Products");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Product list goes here...");
        add(label);

        JButton btnBack = new JButton("Back to Dashboard");
        add(btnBack);

        btnBack.addActionListener(e -> {
            dispose();
            if (role.equals("admin")) {
                new DashboardAdminView(role); // Pindahkan ke DashboardAdminView jika role admin
            } else {
                new DashboardStaffView(role); // Pindahkan ke DashboardStaffView jika role staff
            }
        });

        setVisible(true);
    }
}
