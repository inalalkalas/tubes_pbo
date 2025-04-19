package view;

import controller.ProductController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductView extends JFrame {

    private JTextField txtProductId;
    private JButton btnDelete;
    private ProductController productController;

    public DeleteProductView() {
        // Setup controller
        this.productController = new ProductController();

        // Setup window properties
        setTitle("Delete Product");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        txtProductId = new JTextField(20);
        btnDelete = new JButton("Delete Product");

        // Layout setup
        setLayout(new FlowLayout());

        add(new JLabel("Product ID:"));
        add(txtProductId);
        add(btnDelete);

        // Action listener for delete button
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int productId = Integer.parseInt(txtProductId.getText());

                productController.deleteProduct(productId);
                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
                dispose(); // Close the form
            }
        });

        setVisible(true);
    }
}
