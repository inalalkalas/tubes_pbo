package controller;

import dao.ProductDAO;
import model.Product;
import java.util.List;

public class ProductController {

    private ProductDAO productDAO;

    public ProductController() {
        this.productDAO = new ProductDAO();
    }

    // Menambahkan produk
    public void addProduct(String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int product_stock) {
        Product product = new Product(productName, categoryID, subCategoryID, subSubCategoryID, price, product_stock);
        productDAO.addProduct(product);
    }

    // Mendapatkan daftar produk
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    // Menghapus produk
    public void deleteProduct(int productID) {
        productDAO.deleteProduct(productID);
    }

    // Mengubah informasi produk
    public void updateProduct(int productID, String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int stockQuantity) {
        productDAO.updateProduct(productID, productName, categoryID, subCategoryID, subSubCategoryID, price, stockQuantity);
    }
}
