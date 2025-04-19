package view;

import controller.ProductController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProductView extends JFrame {

    private JTextField txtProductId, txtProductName, txtCategory, txtSubCategory, txtSubSubCategory, txtPrice, txtStock;
    private JButton btnUpdate;
    private ProductController productController;

    public UpdateProductView() {
        // Setup controller
        this.productController = new ProductController();

        // Setup window properties
        setTitle("Update Product");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        txtProductId = new JTextField(20);
        txtProductName = new JTextField(20);
        txtCategory = new JTextField(20);
        txtSubCategory = new JTextField(20);
        txtSubSubCategory = new JTextField(20); 
        txtPrice = new JTextField(20);
        txtStock = new JTextField(20);
        btnUpdate = new JButton("Update Product");

        // Layout setup
        setLayout(new FlowLayout());

        add(new JLabel("Product ID:"));
        add(txtProductId);
        add(new JLabel("Product Name:"));
        add(txtProductName);
        add(new JLabel("Category ID:"));
        add(txtCategory);
        add(new JLabel("SubCategory ID:"));
        add(txtSubCategory);
        add(new JLabel("SubSubCategory ID:"));
        add(txtSubSubCategory);
        add(new JLabel("Price:"));
        add(txtPrice);
        add(new JLabel("Stock Quantity:"));
        add(txtStock);
        add(btnUpdate);

        // Action listener for update button
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productId = Integer.parseInt(txtProductId.getText());
                    String name = txtProductName.getText();
                    String category = txtCategory.getText();
                    String subCategory = txtSubCategory.getText();
                    String subSubCategory = txtSubSubCategory.getText();
                    double price = Double.parseDouble(txtPrice.getText());
                    int stock = Integer.parseInt(txtStock.getText());

                    productController.updateProduct(
                        productId,
                        name,
                        Integer.parseInt(category),
                        Integer.parseInt(subCategory),
                        Integer.parseInt(subSubCategory),
                        price,
                        stock
                    );
                    JOptionPane.showMessageDialog(null, "Product updated successfully!");
                    dispose(); // Close the form
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error updating product: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
