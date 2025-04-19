package view;

import controller.UserController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserView extends JFrame {

    private JTextField txtUsername, txtPassword, txtRole;
    private JButton btnAddUser;
    private UserController userController;

    public AddUserView() {
        // Setup controller
        this.userController = new UserController();

        // Setup window properties
        setTitle("Add User");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        txtUsername = new JTextField(20);
        txtPassword = new JTextField(20);
        txtRole = new JTextField(20);
        btnAddUser = new JButton("Add User");

        // Layout setup
        setLayout(new FlowLayout());

        add(new JLabel("Username:"));
        add(txtUsername);
        add(new JLabel("Password:"));
        add(txtPassword);
        add(new JLabel("Role (Admin/Staff):"));
        add(txtRole);
        add(btnAddUser);

        // Action listener for add user button
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                String role = txtRole.getText();

                userController.addUser(username, password, role);
                JOptionPane.showMessageDialog(null, "User added successfully!");
                dispose(); // Close the form
            }
        });

        setVisible(true);
    }

    // Constructor tambahan agar bisa dipanggil dengan parameter role
    public AddUserView(String role) {
        this(); // Memanggil konstruktor default
        setTitle("Add User - Role: " + role);
    }
}
