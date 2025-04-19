package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import utils.DbConnection;

public class ViewUserView extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private UserController userController;

    public ViewUserView(String role) {
        setTitle("View Users - Role: " + role);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        userController = new UserController();

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"ID", "Username", "Role"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadUsers();

        setVisible(true);
    }

    private void loadUsers() {
        tableModel.setRowCount(0); // Clear existing rows
        try {
            List<User> users = userController.getAllUsers();
            for (User user : users) {
                tableModel.addRow(new Object[]{
                    user.getUserID(),
                    user.getUserName(),
                    user.getRole()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading users: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
